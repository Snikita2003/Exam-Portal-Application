package com.exam.service;



import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.exception.ResNotFoundException;
import com.exam.repo.RoleRepo;
import com.exam.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private RoleRepo roleRepo;
	
	
	
	// creating user.
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		
		User local=this.userRepo.findByUsername( user.getUsername() );
		
		if( local != null )
		{
			throw new ResNotFoundException( local.getUsername());
		}
		else
		{
			// user create.
			for( UserRole  u:userRoles)
			{
				roleRepo.save(u.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local=this.userRepo.save(user);
			
		}
		
		
		return local ;
	}



	@Override
	public User getUser(String username) {
		
		User user=this.userRepo.findByUsername(username);
		return user;
	}



	@Override
	public void deleteUser(Long id) {
		
		this.userRepo.deleteById(id);
		
	}



	@Override
	public User updateDelete( String uname, User user ) {
		
		User upUser=this.userRepo.findByUsername( uname );
		if( upUser != null)
		{
			upUser.setEmail( user.getEmail());
			upUser.setFirstName(user.getFirstName());
			upUser.setUsername(user.getUsername());
			upUser.setPassword(user.getPassword());
			upUser.setPhone(user.getPhone());
			upUser.setUserRoles( user.getUserRoles());
			this.userRepo.save(upUser);
			
			return upUser;
		}
	
		return null;
	}





}
















