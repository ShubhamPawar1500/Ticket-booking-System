package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.model.Users;
import com.example.repo.UserRepo;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return repo.findByName(username);
	}
	
	public void SaveUser(Users user) {
		try {
			repo.save(user);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
