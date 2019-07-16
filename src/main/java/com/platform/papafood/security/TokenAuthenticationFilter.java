package com.platform.papafood.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class TokenAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private String tokenHeaderKey;

    private AuthenticationEntryPoint authenticationEntryPoint;

    protected TokenAuthenticationFilter(RequestMatcher requiresAuthenticationRequestMatcher,
            AuthenticationEntryPoint authenticationEntryPoint, String tokenHeaderKey) {
        super(requiresAuthenticationRequestMatcher);
        this.authenticationEntryPoint = authenticationEntryPoint;
        this.tokenHeaderKey = tokenHeaderKey;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {

        final String token = Optional.ofNullable(httpServletRequest.getHeader(this.tokenHeaderKey)).map(String::trim)
                .orElseThrow(() -> new BadCredentialsException("Missing Authentication Token"));
        final Authentication authentication = new UsernamePasswordAuthenticationToken(token, token);
        return getAuthenticationManager().authenticate(authentication);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException failed) throws IOException, ServletException {
        this.authenticationEntryPoint.commence(request, response, failed);
    }
}
