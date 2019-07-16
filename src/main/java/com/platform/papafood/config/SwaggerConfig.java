package com.platform.papafood.config;

import com.google.common.collect.Sets;
import com.platform.papafood.config.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.builders.PathSelectors.any;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    @Autowired
    private SecurityProperties securityConfig;

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.platform.papafood.controller")).paths(any()).build()
                .consumes(Sets.newHashSet(MediaType.APPLICATION_JSON_VALUE))
                .produces(Sets.newHashSet(MediaType.APPLICATION_JSON_VALUE)).securitySchemes(newArrayList(apiKey()))
                .securityContexts(newArrayList(securityContext())).useDefaultResponseMessages(false)
                .apiInfo(metaData());
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    private ApiInfo metaData() {
        StringBuilder buildVersion = new StringBuilder("PapaFood API<br>");
        return new ApiInfoBuilder().title("PapaFood API").description(buildVersion.toString()).version("1.0").build();
    }

    private ApiKey apiKey() {
        return new ApiKey("Auth", securityConfig.getHeader(), "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().forPaths(PathSelectors.any()).securityReferences(newArrayList(defaultAuth()))
                .build();
    }

    List<SecurityReference> defaultAuth() {
        return newArrayList(new SecurityReference("Auth", new AuthorizationScope[] {}));
    }
}
