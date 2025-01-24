package com.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exam.entity.User;
import com.exam.repo.UserRepo;

// userdetail service interface ki implemetation deni hai.
// data fetch karnar from database which usernmae and password match then it will return user or userdetail.
// else it will throe exception.

@Service
public class UserDetailDataImpl implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
    	User user = this.userRepo.findByUsername(username);
        
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return user; // Make sure User implements UserDetails
    }
}

	
