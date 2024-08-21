package com.jsp.LibraryManagement_System.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.LibraryManagement_System.entity.Author;
import com.jsp.LibraryManagement_System.service.AuthorService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://127.0.0.1:5501/")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@PostMapping("/authors")
	public ResponseEntity<Author> addAuthorDetails(@RequestBody Author author){
	    Author authorfromDB =authorService.addAuthorDetails(author);
	    if(authorfromDB != null) {
	    	return ResponseEntity.status(HttpStatus.ACCEPTED).body(authorfromDB);
	    }else {
	    	return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
	    }
	}
	
	@GetMapping("/authors/byname/{name}")
	public ResponseEntity<Author> getAuthorByName(@PathVariable("name") String name) {
		Author authorfromDb = authorService.getAuthorByName(name);
		if(authorfromDb != null) {
	    	return ResponseEntity.status(HttpStatus.FOUND).body(authorfromDb);
	    }else {
	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	}
	
	@GetMapping("/authors/sort")
	public ResponseEntity getAllAuthorsSortByname() {
		List<Author> authors = authorService.authorssortByName();
		if(!authors.isEmpty()) {
	    	return ResponseEntity.status(HttpStatus.FOUND).body(authors);
	    }else {
	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	}
	
	@GetMapping("/authors/{id}")
	public ResponseEntity getBookcountWrittenByAuthorByid(@PathVariable("id") int id) {
		int count = authorService.numbersofBookWritenByAuthorByid(id);
		if(count != 0) {
	    	return ResponseEntity.status(HttpStatus.FOUND).body(count);
	    }else {
	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(0);
	    }
	}
	
	//remove author by id
	@DeleteMapping("/authors/{id}")
	public ResponseEntity removeAuthorByid(@PathVariable("id") int id) {
		if (authorService.removeAuthorById(id)) {
			return ResponseEntity.status(HttpStatus.FOUND).body("deleted...");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not deleted");
		}
	}
	//update author by id
	@PutMapping("/authors/{id}")
	public ResponseEntity updateAuthorByid(@PathVariable("id") int id,@RequestBody Author author) {
		Author authorfromdb =  authorService.getAuthorById(id);
		if(authorfromdb != null) {
			authorfromdb.setName(author.getName());
			Author upauthor=authorService.addAuthorDetails(authorfromdb);
			return ResponseEntity.status(HttpStatus.FOUND).body(upauthor);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
		}
	}
	
	

}














