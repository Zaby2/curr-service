package com.apigateway.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
class ProxyConfig {
    @Bean
    RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("CURRENCY-SERVICE",
                        route -> route.path("/currency-service/**")
                                .and()
                                .method(HttpMethod.GET)
                                .filters(filter -> filter.stripPrefix(1)
                                )
                                .uri("lb://currency-service"))
                .build();
    }
}