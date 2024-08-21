package com.jsp.LibraryManagement_System.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.jsp.LibraryManagement_System.entity.Author;
import com.jsp.LibraryManagement_System.entity.BookInfo;
import com.jsp.LibraryManagement_System.repository.AuthorRepsitory;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepsitory authorRepsitory;
	
	public Author getAuthorById(int id) {
		return authorRepsitory.findById(id).orElse(null);
	}
	
	public Author addAuthorDetails(Author author) {
		return authorRepsitory.save(author);
	}
	
	public Author getAuthorByName(String name) {
		return authorRepsitory.findByName(name);
	}
	
	public List<Author> authorssortByName(){
		Sort sort = Sort.by("name");
		return authorRepsitory.findAll(sort);
	}
	
	// to return books number by  writen Author
	public int numbersofBookWritenByAuthorByid(int id) {
		Author author = authorRepsitory.findById(id).orElse(null);
		List<BookInfo> books = author.getBookInfos();
		
		return books.size();
	}
	// remove Author By Id
	public boolean removeAuthorById(int id) {
		Author authorfromdb = authorRepsitory.findById(id).orElse(null);
		if(authorfromdb != null) {
			authorRepsitory.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
	

}
















