package com.tennisclub.config;

import com.tennisclub.service.implementation.CustomOAuth2UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;

    public SecurityConfig(CustomOAuth2UserService customOAuth2UserService) {
        this.customOAuth2UserService = customOAuth2UserService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/", "/css/**", "/js/**").permitAll()
                                .anyRequest().authenticated()
                )
            .oauth2Login(oauth -> oauth
                .userInfoEndpoint(info -> info
                    .userService(customOAuth2UserService)
                )
            );
//                .logout(logout -> logout.logoutSuccessUrl("/").permitAll());
        return http.build();
    }
}
