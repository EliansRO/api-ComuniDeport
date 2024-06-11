package com.comunideport.rest.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeHttpRequests(authRequest -> 
                authRequest
                    .requestMatchers("/auth/**").permitAll()
                    .anyRequest().authenticated()
            )
            .formLogin(form -> 
                form
                    .loginPage("/auth/login")
                    .permitAll()
            )
            .logout(logout -> 
                logout
                    .logoutUrl("/auth/logout")
                    .logoutSuccessUrl("/auth/login?logout")
                    .permitAll()
            )
            .build();
    }
}
