package com.restfullProject.restfullProject.ui.controller;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restfullProject.restfullProject.exceptions.UserServiceException;
import com.restfullProject.restfullProject.io.entities.UserEntity;
import com.restfullProject.restfullProject.service.UserService;
import com.restfullProject.restfullProject.shared.dto.UserDto;
import com.restfullProject.restfullProject.ui.model.request.RequestOperationName;
import com.restfullProject.restfullProject.ui.model.request.UserDetailsRequestModel;
import com.restfullProject.restfullProject.ui.model.response.ErrorMessages;
import com.restfullProject.restfullProject.ui.model.response.OperationStatusModel;
import com.restfullProject.restfullProject.ui.model.response.RequestOperationStatus;
import com.restfullProject.restfullProject.ui.model.response.UserRest;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class userController {

	@Autowired
	UserService userService;

	@GetMapping(path = "{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public UserRest getUser(@PathVariable String id) {
		UserRest returnedUserRest = new UserRest();
		UserDto userDto = userService.getUserByUserId(id);
		BeanUtils.copyProperties(userDto, returnedUserRest);
		return returnedUserRest;
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) throws Exception {
		// if (userDetails.getFirstName().isEmpty()) throw new
		// UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
		if (userDetails.getFirstName().isEmpty())
			throw new NullPointerException("the object is null ");
		UserRest userRestResponse = new UserRest();
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);
		UserDto createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser, userRestResponse);
		return userRestResponse;
	}

	@PutMapping(path = "{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public UserRest updateUser(@PathVariable String id, @RequestBody UserDetailsRequestModel userDetails) {
		UserRest userRestResponse = new UserRest();
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);
		UserDto updatedUser = userService.updateUser(id, userDto);
		BeanUtils.copyProperties(updatedUser, userRestResponse);
		return userRestResponse;
	}

	@DeleteMapping(path = "{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public OperationStatusModel deleteUser(@PathVariable String id) {
		OperationStatusModel retrnedValue = new OperationStatusModel();
		retrnedValue.setOperationName(RequestOperationName.DELETE.name());
		userService.deleteUser(id);
		retrnedValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
		return retrnedValue;
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public List<UserRest> getUserList(@RequestParam(defaultValue = "25", value = "limit") int limit,
			@RequestParam(defaultValue = "1", value = "page") int page) {

		return new ArrayList<>();
	}

}
