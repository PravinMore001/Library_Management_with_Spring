package com.jsp.LibraryManagement_System.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jsp.LibraryManagement_System.entity.UserInfo;
import com.jsp.LibraryManagement_System.repository.UserInfoRepository;

@Service
public class LibrarianService {
	
	@Autowired
	private UserInfoRepository repository;
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	// Add Librarian
	public UserInfo addLibrarian(UserInfo info) {
		String userpass = info.getPassword();
		String encodePass = passwordEncoder.encode(userpass);
		info.setPassword(encodePass);
		UserInfo userfromDB = repository.save(info);
		return userfromDB;
	}
	
	// get Librarian By id
	public UserInfo getLibrarianByid(int id) {
		return repository.findById(id).orElse(null);
	}
	// remove Librarian By id
	public boolean deleteLibrarianBYId(int id) {
		UserInfo userInfofromDb = repository.findById(id).orElse(null);
		if(userInfofromDb != null && userInfofromDb.getRole().equals("ROLE_LIBRARIAN")) {
			repository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
	// Update Librarian by id
	
	// display all Librarians
	public List<UserInfo> getAllLibrarians(){
		ArrayList<UserInfo> librarians = new ArrayList<UserInfo>();
		List<UserInfo> UsersfromDb = repository.findAll();
		for(UserInfo u : UsersfromDb) {
			if(u.getRole().equals("ROLE_LIBRARIAN")) {
				librarians.add(u);
			}
		}
		return librarians;
	}
}















