package com.jsp.LibraryManagement_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.jsp.LibraryManagement_System.entity.Author;

@Repository
public interface AuthorRepsitory extends JpaRepository<Author, Integer> {
	
	// find Author by Name
	 Author findByName(String name);
	

}
