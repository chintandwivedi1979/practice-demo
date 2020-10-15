package com.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;

@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class R2DBCConfigurationProperties {

    private String database;
    private String username;
    private String password;
    private String host;
    private String port;
}

