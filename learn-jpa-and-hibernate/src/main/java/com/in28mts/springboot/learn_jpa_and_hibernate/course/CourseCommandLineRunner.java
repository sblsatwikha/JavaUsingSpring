package com.in28mts.springboot.learn_jpa_and_hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//import com.in28mts.springboot.learn_jpa_and_hibernate.course.jdbc.CourseJdbcRepository;
import com.in28mts.springboot.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;
import com.in28mts.springboot.learn_jpa_and_hibernate.course.springJpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
	
//	@Autowired
//	private CourseJdbcRepository courseRepo;
//	@Autowired
//	private CourseJpaRepository courseRepo;
	@Autowired
	private CourseSpringDataJpaRepository courseRepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		for Spring Data JDBC and jpa
//		courseRepo.insert(new Course(1, "Learn Spring", "in28mts"));
//		courseRepo.insert(new Course(2, "Learn AWS", "in28mts"));
//		courseRepo.insert(new Course(3, "Learn Microservices", "in28mts"));
		
//		for Spring Data JPA
		courseRepo.save(new Course(1, "Learn Spring", "in28mts"));
		courseRepo.save(new Course(2, "Learn AWS", "in28mts"));
		courseRepo.save(new Course(3, "Learn Microservices", "in28mts"));
		
		courseRepo.deleteById(1);
		
		System.out.println(courseRepo.findById(2));
		
		System.out.println(courseRepo.count());
		System.out.println(courseRepo.findAll());
		
		System.out.println(courseRepo.findByAuthor("in28mts"));
		System.out.println(courseRepo.findByAuthor(""));
		
		System.out.println(courseRepo.findByName("Learn Microservices"));
		System.out.println(courseRepo.findByName(""));
		
	}

}
