package com.AnnualProject.March.configuration;

import com.AnnualProject.March.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/v1/admin/signup", "/api/v1/applicant/signup").permitAll() // Public endpoints
                        .requestMatchers("/api/v1/admin/**").hasRole("ADMIN") // Admin-only
                        .requestMatchers("/api/v1/applicant/**").hasRole("USER") // Applicant-only
                        .anyRequest().authenticated() // All others require authentication
                )
                .formLogin(formLogin -> formLogin
                        .loginProcessingUrl("/api/v1/admin/login") // Admin login endpoint
                        .loginPage("/admin-login") // Admin login page
                        .defaultSuccessUrl("/admin/dashboard", true) // Redirect admin to their dashboard after successful login
                        .failureUrl("/admin-login?error=true") // Redirect admin to login page with error flag on failure
                        .permitAll() // Allow access to admin login page
                )
                .formLogin(formLogin -> formLogin
                        .loginProcessingUrl("/api/v1/applicant/login") // Applicant login endpoint
                        .loginPage("/applicant-login") // Applicant login page
                        .defaultSuccessUrl("/applicant/dashboard", true) // Redirect applicant to their dashboard after successful login
                        .failureUrl("/applicant-login?error=true") // Redirect applicant to login page with error flag on failure
                        .permitAll() // Allow access to applicant login page
                )

                .csrf(AbstractHttpConfigurer::disable) // Disable CSRF for testing
                .build();
    }

    @Bean
    public DaoAuthenticationProvider adminAuthenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Use BCrypt for password encoding
    }

    @Bean
    public AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
        return (request, response, authentication) -> {
            String redirectUrl = request.getContextPath();
            if (authentication.getAuthorities().stream()
                    .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"))) {
                redirectUrl += "/admin/dashboard";
            } else if (authentication.getAuthorities().stream()
                    .anyMatch(auth -> auth.getAuthority().equals("ROLE_USER"))) {
                redirectUrl += "/applicant/dashboard";
            } else {
                redirectUrl += "/home";
            }

            response.sendRedirect(redirectUrl);
        };
    }
}