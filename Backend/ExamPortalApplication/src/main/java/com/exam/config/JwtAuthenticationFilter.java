package com.exam.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String requestToken = request.getHeader("Authorization");
        String username = null;
        String token = null;

        // Check if Authorization header exists and starts with "Bearer "
        if (requestToken != null && requestToken.startsWith("Bearer ")) {
            token = requestToken.substring(7); // Extract the token part after "Bearer "
            try {
                // Extract username from the token
                username = this.jwtTokenHelper.getUserNameFromToken(token);
            } catch (ExpiredJwtException e) {
                System.out.println("JWT token has expired: " + e.getMessage());
            } catch (MalformedJwtException e) {
                System.out.println("Invalid JWT token: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error parsing JWT token: " + e.getMessage());
            }
        } else if (requestToken != null) {
            System.out.println("JWT token does not begin with Bearer!");
        } else {
            System.out.println("No JWT token found in the request headers!");
        }

        
        // If username is valid and authentication is not already set in the security context
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // Load user details by username
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            if (this.jwtTokenHelper.validateToken(token, userDetails)) {
            	
                // If the jwt token is valid, set the currectt authentication details in the security context
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                
                SecurityContextHolder.getContext().setAuthentication(authToken);
            } else {
                System.out.println("JWT token validation failed!");
            }
        }

        // Continue with the request processing
        filterChain.doFilter(request, response);
    }
}







