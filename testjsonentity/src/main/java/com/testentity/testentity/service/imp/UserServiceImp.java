package com.testentity.testentity.service.imp;

import org.springframework.beans.factory.annotation.Autowired;

import com.testentity.testentity.io.entities.UserEntity;
import com.testentity.testentity.io.repository.UserRepository;
import com.testentity.testentity.service.UserService;



public class UserServiceImp implements UserService {

	@Autowired
	UserRepository  userRepository ;
	
	@Override
	public UserEntity findByUserId() {
		UserEntity userEntity=userRepository.findByUserId("1") ;
		return userEntity ; 
	}

}
