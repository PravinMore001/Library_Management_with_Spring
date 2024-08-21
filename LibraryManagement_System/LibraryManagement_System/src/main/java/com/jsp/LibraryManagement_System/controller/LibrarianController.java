package com.jsp.LibraryManagement_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.LibraryManagement_System.entity.BookInfo;
import com.jsp.LibraryManagement_System.service.BookService;

@RestController
@RequestMapping("/api/v1")
public class LibrarianController {
	
	@Autowired
	private BookService bookService;
	
	// Add Book 
	@GetMapping("/books")
	public ResponseEntity<BookInfo> addBookDetails(@RequestBody BookInfo bookInfo){
	 BookInfo bookdetails =	bookService.addBookDetails(bookInfo);
	 if(bookdetails != null) {
		 return ResponseEntity.status(HttpStatus.CREATED).body(bookdetails);
	 }else {
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	 }
	}
	
	
}
