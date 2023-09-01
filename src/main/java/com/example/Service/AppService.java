package com.example.Service;

import java.util.List;

import com.example.Dao.AppDto;

public interface AppService {
	
	public String createApplication(AppDto appDto);

	public List<AppDto>fetchApp(Integer userId);
	
	
}
