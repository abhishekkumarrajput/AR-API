package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.AppEntity;

public interface AppRepository extends JpaRepository<AppEntity, Long> {

	//userId not a primary key so weed to create custom query  to get userId
	
	public List<AppEntity>fetchUserApps();  //if login user admin then get all the application
	
	@Query(value="from AppEntity where userId:userId")
	public List<AppEntity>fetchCaseWorkerApp(Integer userId);   //if user not a admin then i need to get application create by that particular user
	
}
