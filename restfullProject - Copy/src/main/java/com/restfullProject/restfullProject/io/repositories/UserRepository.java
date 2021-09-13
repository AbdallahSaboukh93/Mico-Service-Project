package com.restfullProject.restfullProject.io.repositories;

import org.springframework.data.repository.CrudRepository;

import com.restfullProject.restfullProject.io.entities.UserEntity;
import com.restfullProject.restfullProject.shared.dto.UserDto;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

	UserEntity findByEmail(String email);

	UserEntity findByUserId(String userId);
}
