package com.kopibru.librarysystem.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClient;

@Configuration
public class BookManagementClientConfig {

    public static final String INTERNAL_API_KEY_HEADER = "X-Internal-Api-Key";

    @Bean
    public RestClient bookManagementRestClient(
            @Value("${bookmanagement.base-url}") String baseUrl,
            @Value("${bookmanagement.internal-api-key}") String internalApiKey) {
        if (!StringUtils.hasText(internalApiKey)) {
            throw new IllegalStateException(
                    "bookmanagement.internal-api-key must be set (env INTERNAL_API_KEY) "
                            + "and match BookManagement app.internal-api-key.");
        }
        return RestClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(INTERNAL_API_KEY_HEADER, internalApiKey)
                .build();
    }
}
