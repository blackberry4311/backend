package com.platform.papafood.config.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Configuration
@Data
@Validated
public class SecurityProperties {

    @NotBlank
    @Value("${security.header:Bearer}")
    private String header;

    @NotNull
    @Value("${security.token.timeoutHours:24}")
    private Integer expiredInHours;
}
