package com.springdatarest.springdatarest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springdatarest.springdatarest.entity.User;
import com.springdatarest.springdatarest.entity.UserDetial;
import com.springdatarest.springdatarest.repository.UserDetialRepository;
import com.springdatarest.springdatarest.repository.UserRepository;

@SpringBootApplication
public class SpringDataRestApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserDetialRepository userDetialRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = User.builder().firstName("abdalah").lastName("saboukh").email("abd@yahoo.com").build();
		userRepository.save(user);
		UserDetial userDetial = UserDetial.builder().address("abdalahaddress").postalCode("23255").user(user).build();
		UserDetial userDetial2 = UserDetial.builder().address("abdalahaddress2").postalCode("1111").user(user).build();
		userDetialRepository.save(userDetial);
		userDetialRepository.save(userDetial2);

		User user1 = User.builder().firstName("mahmoud").lastName("saboukh").email("mah@yahoo.com").build();
		userRepository.save(user1);
		UserDetial userDetial3 = UserDetial.builder().address("use2address").postalCode("261").user(user1).build();
		UserDetial userDetial4 = UserDetial.builder().address("user2address").postalCode("1111").user(user1).build();
		userDetialRepository.save(userDetial3);
		userDetialRepository.save(userDetial4);

		User user2 = User.builder().firstName("ahmed").lastName("saboukh").email("ahmed@yahoo.com").build();
		userRepository.save(user2);
	}

}
