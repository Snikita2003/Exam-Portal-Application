package com.exam.config;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.exam.service.UserDetailDataImpl;

import io.jsonwebtoken.lang.Arrays;
import io.jsonwebtoken.lang.Collections;
// jwtAuthenticationEntryPoint- unauthorisedHandler class

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig {

    public static final String[] PUBLIC_URLS = {
        "/generate-token", 
        "/user/" ,
        "/category/",
        "/question/",
        "/quiz/"
        
    };

    
    // http://localhost:8080/user/john  to get method (api in postman).
    //  http://localhost:8080/user/john_doe   - get userDetail get -method  .(pass karych username,password in auhtoriazation bodu).
    // http://localhost:8080/generate-token  - (post method) it will give u token if(username,password is correct will give u token).
    
    
    
    @Autowired
    private JwtAuthentiEntryPoint unauthorizedHandler;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private UserDetailDataImpl userDetailDataImpl;
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
        .cors()
        .and()
            .authorizeHttpRequests()
            .requestMatchers(PUBLIC_URLS).permitAll() // Permits all URLs defined in PUBLIC_URLS
            .requestMatchers(HttpMethod.OPTIONS).permitAll()
            .requestMatchers("/currentuser").authenticated()
            .requestMatchers(HttpMethod.GET ).permitAll()
            
            .anyRequest().authenticated()           // Requires authentication for other requests
            .and()
            .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // Use stateless sessions (no server-side session storage)

        // Add custom authentication filter for JWT
        http.authenticationProvider(daoAuthenticationProvider()); 
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    
  
    
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
    
    
    @Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}
    
    
    // Authentication provider that uses the UserDetailsService and PasswordEncoder
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailDataImpl);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
}








