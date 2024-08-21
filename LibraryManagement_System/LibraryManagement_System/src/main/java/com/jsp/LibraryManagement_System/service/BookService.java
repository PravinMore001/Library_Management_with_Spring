package com.jsp.LibraryManagement_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.LibraryManagement_System.entity.BookInfo;
import com.jsp.LibraryManagement_System.repository.Bookrepository;

@Service
public class BookService {
	
	@Autowired
	private Bookrepository bookrepository;
	
	public BookInfo addBookDetails(BookInfo bookInfo) {
	 	return bookrepository.save(bookInfo);
	}
	

}
