package com.jsp.LibraryManagement_System.configuration;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jsp.LibraryManagement_System.entity.UserInfo;
import com.jsp.LibraryManagement_System.repository.UserInfoRepository;

public class UserInfoUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserInfoRepository repository;
	// To get Username from database and provide to spring security config
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo info = repository.findByusername(username);
		return new UserInfoUserDetails(info);
	}

}
