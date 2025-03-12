package com.igeos.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/api/**").permitAll()  // Permite acesso a /api/** sem autenticação
                .anyRequest().authenticated()          // Exige autenticação para outras requisições
            )
            .csrf(csrf -> csrf.disable());  // Desativa CSRF para APIs REST sem estado

        return http.build();  // Retorna a configuração de segurança
    }
}
