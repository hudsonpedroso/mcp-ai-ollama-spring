package com.hudsonpedroso.mcp_spring.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "ai.provider.api")
public class ApiProperties {
    private String url;
    private String model;
}