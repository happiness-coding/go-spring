package com.nvbinhsoft.blog.query.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class QuerySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/articles/**").permitAll()
            .antMatchers("/categories/**").permitAll()
            .antMatchers("/comments/**").permitAll()
            .antMatchers("/tags/**").permitAll()
            .antMatchers("/users/**").permitAll()
            .antMatchers("/statistics/**").permitAll()
            .anyRequest().authenticated();
    }
}
