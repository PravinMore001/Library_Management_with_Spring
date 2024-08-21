package com.jsp.LibraryManagement_System.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.LibraryManagement_System.entity.UserInfo;
import com.jsp.LibraryManagement_System.service.LibrarianService;

@RestController
@RequestMapping("/api/v1")
public class AdminController {
	@Autowired
	private LibrarianService service;

	// @GetMapping("/admins") - for Add Admin
	@PostMapping("/librarians")
	public ResponseEntity<UserInfo> addLibrarian(@RequestBody UserInfo userInfo) {
		System.out.println(userInfo);
		UserInfo librarian = service.addLibrarian(userInfo);
		if (librarian != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(librarian);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	// get Librarian By id
	@GetMapping("/librarians/{id}")
	public ResponseEntity getLibrarianByid(@PathVariable("id") int id) {
		UserInfo userInfromDB = service.getLibrarianByid(id);
		if (userInfromDB != null && userInfromDB.getRole().equals("ROLE_LIBRARIAN")) {
			return ResponseEntity.status(HttpStatus.FOUND).body(userInfromDB);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	// remove Librarian By id
	@DeleteMapping("librarians/{id}")
	public ResponseEntity deleteLibrarianById(@PathVariable("id") int id) {
		if (service.deleteLibrarianBYId(id)) {
			return ResponseEntity.status(HttpStatus.FOUND).body("Record Deleted");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record Not Deleted");
		}
	}

	// Update Librarian by id
	@PutMapping("/librarians/{id}")
	public ResponseEntity updateLibrarianByid(@RequestBody UserInfo userInfo, @PathVariable("id") int id) {
		UserInfo userInfofromDb = service.getLibrarianByid(id);
		userInfofromDb.setUsername(userInfo.getUsername());
		service.addLibrarian(userInfofromDb);
		return ResponseEntity.status(HttpStatus.FOUND).body(userInfofromDb);
	}

	// display all Librarians
	@GetMapping("/librarians")
	public ResponseEntity getAllLibrarians() {
		List<UserInfo> userInfos = service.getAllLibrarians();
		return ResponseEntity.status(HttpStatus.FOUND).body(userInfos);
	}

}
