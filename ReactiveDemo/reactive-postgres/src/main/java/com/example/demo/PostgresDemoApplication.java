package com.example.demo;

import com.example.demo.config.R2DBCConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableConfigurationProperties(R2DBCConfigurationProperties.class)
@EnableWebFlux
public class PostgresDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgresDemoApplication.class, args);
	}

}
