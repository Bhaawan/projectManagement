package bhaawan.project.ProjectManagement.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csfr->csfr.disable())
                .authorizeHttpRequests(auth -> auth
            .requestMatchers("/auth/register", "/get/all", "/auth/login", "/")
            .permitAll().anyRequest().authenticated());

        return http.build();
    }
}
