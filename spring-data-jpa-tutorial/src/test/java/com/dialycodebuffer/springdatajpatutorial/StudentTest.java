package com.dialycodebuffer.springdatajpatutorial;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.dialycodebuffer.springdatajpatutorial.entity.Student;
import com.dialycodebuffer.springdatajpatutorial.repository.StudentRepository;
@SpringBootTest
@DataJpaTest
class StudentTest {

	@Autowired
	StudentRepository studentRepository ;
	
	
	@Test
	public void testSaveStudent() {
     Student student =new Student();
     student.setEmailId("abdallah@gmail.com");
     student.setFistName("abdallah");	
     student.setLastName("sabokh");
     student.setGuardianEmail("GuardianEmail");
     student.setGuardianMobile("ssfdffff");
     student.setGuardianName("dfvdvdvfd");
    // studentRepository.save(student) ;
	}
}
