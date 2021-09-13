package com.daillycodebuffer.departmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daillycodebuffer.departmentservice.entity.Department;
import com.daillycodebuffer.departmentservice.service.DepartmentService;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	@PostMapping
	public Department saveDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}

	@GetMapping(path = "/{id}")
	public Department getDepartmentById(@PathVariable(value = "id") Long departmentId) {
		return departmentService.getDepartmentById(departmentId);
	}
}
