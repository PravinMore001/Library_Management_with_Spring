package com.jsp.LibraryManagement_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jsp.LibraryManagement_System.entity.UserInfo;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
	
	// Find User by Username
	UserInfo findByusername(String name);
	
		// get Librarian By id
		// remove Librarian By id
		// Update Librarian by id
		// display all Librarians

}
