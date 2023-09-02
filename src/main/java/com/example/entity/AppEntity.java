package com.example.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long caseNumber;
	private String fullName;
	private String Email;
	private String password;
	private String phoneNumber;
	private String Gender;
	private Date Dob;
	private Long ssnNumber;
	private String houseName;
	@ManyToOne
	@JoinColumn(name="userId")
	private UserEntity user;  //many application create by Singleuser    //which user create by application

	
}
