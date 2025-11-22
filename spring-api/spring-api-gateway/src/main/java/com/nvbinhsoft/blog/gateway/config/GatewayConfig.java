package com.nvbinhsoft.blog.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

  @Bean
  public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
    return builder
        .routes()
        .route("article_route", r -> r.path("/articles/**").uri("lb://article-service"))
        .route("category_route", r -> r.path("/categories/**").uri("lb://category-service"))
        .build();
  }
}
