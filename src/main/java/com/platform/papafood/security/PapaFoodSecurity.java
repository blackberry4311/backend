package com.platform.papafood.security;

import com.platform.papafood.commons.ApiConstant;
import com.platform.papafood.config.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class PapaFoodSecurity extends WebSecurityConfigurerAdapter {
    private static final RequestMatcher PUBLIC_URLS = new OrRequestMatcher(
            new AntPathRequestMatcher("/swagger-ui.html**"),
            new AntPathRequestMatcher("/webjars/**"),
            new AntPathRequestMatcher("/favicon.ico"),
            new AntPathRequestMatcher("/csrf"),
            new AntPathRequestMatcher("/v2/api-docs"),
            new AntPathRequestMatcher("/swagger-resources/**"),
            new AntPathRequestMatcher(ApiConstant.LOGIN),
            new AntPathRequestMatcher(ApiConstant.HEALTH)
    );

    private static final RequestMatcher AUTHENTICATED_URLS = new NegatedRequestMatcher(PUBLIC_URLS);

    @Autowired
    private TokenAuthenticationProvider provider;

    @Autowired
    private SecurityProperties securityConfig;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().requestMatchers(PUBLIC_URLS);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(provider);
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .sessionManagement()
                .sessionCreationPolicy(STATELESS)
                .and()
                .cors()
                .and()
                .exceptionHandling()
                // this entry point handles when you request a protected page and you are not yet
                // authorized
                .authenticationEntryPoint(forbiddenEntryPoint())
                .accessDeniedHandler(accessDeniedHandler())
                .and()
                .addFilterBefore(tokenAuthenticationFilter(), AnonymousAuthenticationFilter.class)
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable()
                .formLogin().disable()
                .httpBasic().disable()
                .logout().disable();
    }

    @Bean
    AuthenticationEntryPoint unauthenticatedEntryPoint() {
        return new HttpStatusEntryPoint(UNAUTHORIZED);
    }

    private HttpStatusEntryPoint forbiddenEntryPoint() {
        return new HttpStatusEntryPoint(FORBIDDEN);
    }

    private AccessDeniedHandler accessDeniedHandler() {
        return (request, response, accessDeniedException) -> response.setStatus(FORBIDDEN.value());
    }

    // Not create @Bean here, otherwise web.ignoring not work
    TokenAuthenticationFilter tokenAuthenticationFilter() throws Exception {
        final TokenAuthenticationFilter filter = new TokenAuthenticationFilter(
                AUTHENTICATED_URLS,
                unauthenticatedEntryPoint(),
                securityConfig.getHeader()
        );
        filter.setAuthenticationManager(authenticationManager());
        filter.setAuthenticationSuccessHandler(successHandler());
        return filter;
    }

    @Bean
    SimpleUrlAuthenticationSuccessHandler successHandler() {
        final SimpleUrlAuthenticationSuccessHandler successHandler = new SimpleUrlAuthenticationSuccessHandler();
        successHandler.setRedirectStrategy(new NoRedirectStrategy());
        return successHandler;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
