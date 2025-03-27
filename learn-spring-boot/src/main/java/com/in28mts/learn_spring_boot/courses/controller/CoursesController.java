package com.in28mts.learn_spring_boot.courses.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28mts.learn_spring_boot.courses.bean.Course;


@RestController
public class CoursesController {

	@GetMapping("/courses")
	public List<Course> getAllCourses(){
		return Arrays.asList(new Course(1, "Learn Microservices", "in28mts"), new Course(2, "Learn Microservices - 2", "in28mts"));
	}
	
	@GetMapping("/courses/1")
	public Course getCourseDetails(){
		return new Course(1, "Learn Microservices - 1", "in28mts");
	}
}
