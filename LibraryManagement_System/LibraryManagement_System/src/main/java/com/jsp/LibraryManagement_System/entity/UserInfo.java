package com.jsp.LibraryManagement_System.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "id")
	@SequenceGenerator(name = "id", allocationSize = 1,initialValue = 101)
	private int userId;
	
	@Column(unique = true)
	private String username;
	
	private String password;
	
	private String role;

}
