package com.example.ServiceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.Dao.AppDto;
import com.example.Exception.SsnWebException;
import com.example.Repository.AppRepository;
import com.example.Repository.UserRepository;
import com.example.Service.AppService;
import com.example.entity.AppEntity;
import com.example.entity.UserEntity;

@Service
public class AppServiceImpl implements AppService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AppRepository appRepository;

	@Autowired
	private UserRepository userRepository;

	private static final String SSA_WEB_API_URL = "https://ssa.web.app/{ssn}"; // this is dammy url now we are replace
																				// with the original url

	@Override
	public String createApplication(AppDto appDto) {
		// logic :- citizen belongs to rohde ishland state then onlyn application will
		// be create otherwise application will not be create

		try {

			WebClient webClient = WebClient.create(); // webclient object Mil gaya
			String stateName = webClient.get().uri(SSA_WEB_API_URL, appDto.getSsnNumber()).retrieve()
					.bodyToMono(String.class).block();
			if ("RI".equals(stateName)) {
				// valid citizen app
				UserEntity userEntity = this.userRepository.findById(appDto.getUserId()).get(); // which user create application
																								
				AppEntity appEntity = this.modelMapper.map(appDto, AppEntity.class);
				appEntity.setUser(userEntity);
				appRepository.save(appEntity);
				return "Application succesfully created with caseNumber" + appEntity.getCaseNumber();
			}
		} catch (Exception e) {
			throw new SsnWebException(e.getMessage());
		}
		return "Invalid SSN";
	}

	@Override
	public List<AppDto> fetchApp(Integer userId) {
		// TODO Auto-generated method stub         // get CitizenApllication based on caseWorker(userId)
		return null;
	}

}
