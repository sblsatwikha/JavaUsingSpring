package com.in28mts.springboot.learn_jpa_and_hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//import com.in28mts.springboot.learn_jpa_and_hibernate.course.jdbc.CourseJdbcRepository;
import com.in28mts.springboot.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
	
//	@Autowired
//	private CourseJdbcRepository courseRepo;
	@Autowired
	private CourseJpaRepository courseRepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		courseRepo.insert(new Course(1, "Learn Spring", "in28mts"));
		courseRepo.insert(new Course(2, "Learn AWS", "in28mts"));
		courseRepo.insert(new Course(3, "Learn Microservices", "in28mts"));
		
		courseRepo.delete(1);
		
		System.out.println(courseRepo.findById(2));
		
	}

}
