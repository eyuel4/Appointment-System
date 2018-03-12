package com.tadhack.orlandoappointment.orlandoappointment.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableAutoConfiguration
public class SpringConfig {
    @Bean
    public RestTemplate restTemplate () {
        return new RestTemplate();
    }

    @Bean
    public RestOperations restOperations (RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.basicAuthorization("17437863","aFFgSWUUeWVpIoMUOEdnL26GBQB3uR05").build();
    }
}
