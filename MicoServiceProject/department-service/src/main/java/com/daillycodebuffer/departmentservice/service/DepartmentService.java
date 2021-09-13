package com.daillycodebuffer.departmentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.daillycodebuffer.departmentservice.entity.Department;
import com.daillycodebuffer.departmentservice.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	public Department saveDepartment(@RequestBody Department department) {
		log.info("inside saveDepartment method department controller");
		return departmentRepository.save(department);
	}

	public Department getDepartmentById(@PathVariable(value = "id") Long departmentId) {
		log.info("inside getDepartmentById method department controller");
		return departmentRepository.findById(departmentId).get();
	}

}
