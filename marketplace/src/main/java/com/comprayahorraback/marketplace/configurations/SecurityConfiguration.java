package com.comprayahorraback.marketplace.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http
            .csrf()
            .disable()
            .authorizeHttpRequests()
                //APIs that can be accessed by the admin.
                .requestMatchers("/product/create",
                                             "/product/get/{id}",
                                             "/product/delete/{id}",
                                             "/product/update/{id}",
                                             "/sale/get/all/**",
                                             "/admin/**",
                                             "/category/**"
                                    
                                ).hasAnyRole("ADMIN")
                
                // APIs that can be accessed by both the admin and the client.
                .requestMatchers("/sale/get/{id}"
                
                                ).hasAnyRole("ADMIN", "CLIENTE")

                // Apis that can accessed by the client
                .requestMatchers("/userca/update/password/{id}",
                                            "/comment/**"
                                    
                                ).hasAnyRole("CLIENT")

                // Apis that can accessed by anyone
                .requestMatchers("/auth/**").permitAll()

            .anyRequest()
            .authenticated()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);


        return http.build();
    }

}
