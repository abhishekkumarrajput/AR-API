package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.AppService;

@RestController
public class AppController {
	
	@Autowired
	private AppService appService;
	
	@GetMapping
	public ResponseEntity<String>getALllSUer(){
		return null;
	}
	

}
