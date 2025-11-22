package com.nvbinhsoft.blog.query.config;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;

@Configuration
@EnableWebSecurity
public class QuerySecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,
                                                   Converter<Jwt, Collection<GrantedAuthority>> keycloakJwtRoleConverter) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers(
                    "/articles/**",
                    "/categories/**",
                    "/comments/**",
                    "/tags/**",
                    "/users/**",
                    "/statistics/**",
                    "/v3/api-docs/**",
                    "/swagger-ui/**",
                    "/swagger-ui.html")
                .permitAll()
                .anyRequest()
                .authenticated())
            .oauth2ResourceServer(oauth2 -> oauth2
                .jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter(keycloakJwtRoleConverter))));

        return http.build();
    }

    @Bean
    public Converter<Jwt, Collection<GrantedAuthority>> keycloakJwtRoleConverter(
        @Value("${blog.security.keycloak.client-id:blog-api}") String clientId) {
        return new KeycloakJwtRoleConverter(clientId);
    }

    private JwtAuthenticationConverter jwtAuthenticationConverter(
        Converter<Jwt, Collection<GrantedAuthority>> keycloakJwtRoleConverter) {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(keycloakJwtRoleConverter);
        return converter;
    }
}
