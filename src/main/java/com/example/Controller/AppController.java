package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	
	@Autowired
	private AppService appService;

@deleteMapping("/{Intterger usrId}")
public void deleteUserFetchRecord(@pathvarble Interger USerId){
thios.appService.deletingByUser(IuserId);
	return "user Successfully Delete by userId";
	{
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<AppDto>updateUser(@RequestBody AppDto app,Integer userId ){
	String appDto=this.appService.updateUser(app,userId);
    return ResponseEntity<AppDto>(appDto.httpstatus.ok);
	}
	
  @PostMapping("/app")
	public ResponseEntity<String>createApp(@RequestBody AppDto appDto){
		String createApplication = appService.createApplication(appDto);
		return new ResponseEntity<String>(createApplication,HttpStatus.OK);
	}

@GetMapping("/{userId}")
public ResponseEntity<List<AppDto>>getApps(@PathVariable Integer userId){
	List<AppDto> fetchApp = this.appService.fetchApp(userId);
	return new ResponseEntity<List<AppDto>>(fetchApp,HttpStatus.OK);
}

	
}
