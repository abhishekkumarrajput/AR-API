package com.example.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Dao.AppDto;
import com.example.Service.AppService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class AppController {
private Logger logger= LoggerFactory.getLogger(AppController.class);
	
	@Autowired
	private AppService appService;
	
  @PostMapping("/app")
	public ResponseEntity<String>createApp(@RequestBody AppDto appDto){
		String createApplication = appService.createApplication(appDto);
		return new ResponseEntity<String>(createApplication,HttpStatus.OK);
	}

@GetMapping("/{getUserId}")
public ResponseEntity<List<AppDto>>getApps(@PathVariable Integer getUserId){
	List<AppDto> fetchApp = this.appService.fetchApp(getUserId);
	return new ResponseEntity<List<AppDto>>(fetchApp,HttpStatus.ACCEPTED);
}

	
}
