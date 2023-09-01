package com.example.Dao;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppDto {
	
	private Long caseNumber;
	private String fullName;
	private String Email;
	private String password;
	private String phoneNumber;
	private String Gender;
	private Date Dob;
	private Long ssnNumber;
	private Integer userId;
	

}
