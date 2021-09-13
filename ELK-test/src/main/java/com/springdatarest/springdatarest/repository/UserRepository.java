package com.springdatarest.springdatarest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.springdatarest.springdatarest.entity.User;

//@RepositoryRestResource(path = "members")
public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByFirstName(@Param("firstName") String firstName);
}
