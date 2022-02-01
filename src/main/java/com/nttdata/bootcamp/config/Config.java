package com.nttdata.bootcamp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Config {
    @Value("${application.endpoints.url.mc_customer}")
    private String urlEndpointCustomer;

    @Value("${application.endpoints.url.mc_product}")
    private String urlEndpointProduct;

    @Bean
    public WebClient webClientCustomer() {
        return WebClient.builder()
                .baseUrl(urlEndpointCustomer)
                .build();
    }
    @Bean
    public WebClient webClientProduct() {
        return WebClient.builder()
                .baseUrl(urlEndpointProduct)
                .build();
    }
}
