package com.daillycodebuffer.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daillycodebuffer.userservice.VO.ResponseTemplateVO;
import com.daillycodebuffer.userservice.entity.User;
import com.daillycodebuffer.userservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@GetMapping(path = "/{id}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable(name = "id") Long userId) {
		return userService.getUserWithDepartment(userId);
	}
}
