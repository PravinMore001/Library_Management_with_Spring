package com.jsp.LibraryManagement_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.LibraryManagement_System.entity.BookInfo;

@Repository
public interface Bookrepository extends JpaRepository<BookInfo, Integer> {
	
}
