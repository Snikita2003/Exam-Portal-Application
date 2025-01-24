package com.exam.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.service.UserService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	UserDetails userDetails;
	
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception
	{
		
		Set<UserRole> roles=new HashSet<>();
		Role role=new Role();
		role.setRoleId(45L);
		role.setRoleName("NORMAL");
		
		UserRole userRole=new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		roles.add(userRole);
		return this.userService.createUser(user, roles);
	}
	
	 
	//get user by username;
	@GetMapping("/{username}")
	public User getUser(@PathVariable String username)
	{
		return this.userService.getUser(username);
		
	}
	
	
	@DeleteMapping("/{userId}")
	public void deleteUseById( @PathVariable(name="userId") Long userId)
	{
		this.userService.deleteUser( userId);
	}
	
	
	
	@PutMapping("/{uname}")
	public User updateUserByuname( @PathVariable String uname, @RequestBody User user )
	{
		return this.userService.updateDelete( uname ,user );
	}
	
}













