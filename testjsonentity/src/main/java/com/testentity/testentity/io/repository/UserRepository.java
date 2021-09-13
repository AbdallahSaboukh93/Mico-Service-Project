package com.testentity.testentity.io.repository;

import org.springframework.data.repository.CrudRepository;

import com.testentity.testentity.io.entities.UserEntity;


public interface UserRepository extends CrudRepository<UserEntity, Long> {

	UserEntity findByUserId(String string);
}
