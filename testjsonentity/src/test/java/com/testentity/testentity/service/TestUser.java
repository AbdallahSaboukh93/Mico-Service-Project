package com.testentity.testentity.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testentity.testentity.io.entities.Properties;
import com.testentity.testentity.io.entities.UserEntity;
import com.testentity.testentity.io.repository.UserRepository;


import net.minidev.json.parser.ParseException;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TestUser {

	@Autowired
	UserRepository userRepository ;
	
	@Test
	public void testfindBy() throws ParseException, JsonMappingException, JsonProcessingException {
		UserEntity userEntity=userRepository.findByUserId("1") ;
		ObjectMapper objectMapper = new ObjectMapper();
		Properties properties = objectMapper.readValue(userEntity.getProperties(), Properties.class);
		userEntity.setProperties("");
		String propojson=  objectMapper.writeValueAsString(properties);
		assertNotNull(propojson);
	}
	
	
	
}
