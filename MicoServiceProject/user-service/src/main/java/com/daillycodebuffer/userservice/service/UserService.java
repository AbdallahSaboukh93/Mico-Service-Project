package com.daillycodebuffer.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.daillycodebuffer.userservice.VO.Department;
import com.daillycodebuffer.userservice.VO.ResponseTemplateVO;
import com.daillycodebuffer.userservice.entity.User;
import com.daillycodebuffer.userservice.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	RestTemplate restTemplate;

	public User createUser(@RequestBody User user) {
		log.info("inside createUser in UserController");
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		log.info("inside getUserWithDepartment in UserController");
		ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
		User user = userRepository.findByUserId(userId);
		Department department = restTemplate
				.getForObject("http://DEPARMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);
		responseTemplateVO.setUser(user);
		responseTemplateVO.setDepartment(department);
		return responseTemplateVO;
	}

}
