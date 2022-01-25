package com.nttdata.bootcamp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
    @Bean
    public WebClient webClientProduct() {
        return WebClient.builder()
                .baseUrl(urlEndpointProduct)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
