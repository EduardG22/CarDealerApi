package com.cardealer.car.security;

import com.cardealer.car.security.filter.AuthenticationFilter;
import com.cardealer.car.security.filter.ExceptionHandlerFilter;
import com.cardealer.car.security.filter.JWTAuthorizationFilter;
import com.cardealer.car.security.manager.CustomAuthenticationManager;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    CustomAuthenticationManager customAuthenticationManager;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        AuthenticationFilter authenticationFilter = new AuthenticationFilter(customAuthenticationManager);
        authenticationFilter.setFilterProcessesUrl("/authenticate");

       http
               .csrf(AbstractHttpConfigurer::disable)
               .authorizeHttpRequests((authorize) -> authorize
                       .requestMatchers(HttpMethod.POST, SecurityConstants.REGISTER_PATH).permitAll()
                       .requestMatchers("/v2/api-docs",
                               "/v3/api-docs",
                               "/v3/api-docs/**",
                               "/swagger-resources",
                               "/swagger-resources/**",
                               "/configuration/ui",
                               "/configuration/security",
                               "/swagger-ui/**",
                               "/webjars/**",
                               "/swagger-ui.html").permitAll()
//                       .requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
 //                      .requestMatchers(HttpMethod.POST).hasRole("ADMIN")
 //                      .requestMatchers(HttpMethod.GET).permitAll()
                       .anyRequest().authenticated())
               .addFilterBefore(new ExceptionHandlerFilter(), AuthenticationFilter.class)
               .addFilter(authenticationFilter)
               .addFilterAfter(new JWTAuthorizationFilter(), AuthenticationFilter.class)
               .httpBasic(Customizer.withDefaults())
               .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }

}