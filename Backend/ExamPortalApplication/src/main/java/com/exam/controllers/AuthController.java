package com.exam.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.exam.config.JwtTokenHelper;
import com.exam.entity.JwtRequest;
import com.exam.entity.JwtResponce;
import com.exam.entity.User;

@CrossOrigin( origins =  "http://localhost:4200" )
@RestController
public class AuthController {

    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    
    
    
    @PostMapping("/generate-token")
    public ResponseEntity< JwtResponce > generateToken(@RequestBody JwtRequest request   ) throws Exception {
        authenticate( request.getUsername(), request.getPassword()  );
        
        UserDetails userDetails = this.userDetailsService.loadUserByUsername( request.getUsername());
        String token = this.jwtTokenHelper.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponce(token));
    }

    
    private void authenticate(String username, String password) throws Exception {
        try {
            this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));
        }
         catch (DisabledException e) {
            throw new Exception("USER_DISABLED-  "+e.getMessage() );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS - "+ e.getMessage() );
        }
    }

    
    // returns the details of the currect/login user.
    // this is not public currect user. so we want interceptor which add each request in header auuthorization.
    
    @GetMapping("/currentuser")
    public User getCurrentUser( Principal principal
    		) {
    	
    	if (principal == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User is not authenticated/ principle not found");
        }
    	
    	// Logic to fetch user based on the Principal's name
        String username = principal.getName();
        System.out.println("Principal - "+ principal.getName() );
        
        return (User) this.userDetailsService.loadUserByUsername(username);
        
    
    }
   }





