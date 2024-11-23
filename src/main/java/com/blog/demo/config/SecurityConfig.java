//package com.blog.demo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests()  // Use authorizeHttpRequests instead of authorizeRequests
//                .requestMatchers("/login", "/public/**").permitAll() // Use requestMatchers instead of antMatchers
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .and()
//                .build();
//    }
//}
