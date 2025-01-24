package com.exam.service;

import java.util.*;

import com.exam.entity.User;
import com.exam.entity.UserRole;

public interface UserService {

	//userroles ke set.
	User createUser( User user, Set<UserRole> userRoles ) throws Exception;
	User getUser(String username);
	void deleteUser(Long id);
	User updateDelete(String uname,User user);
	
}
