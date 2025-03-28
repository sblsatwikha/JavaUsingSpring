package com.in28mts.learn_spring_boot.courses.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in28mts.learn_spring_boot.courses.bean.Course;
import com.in28mts.learn_spring_boot.courses.springdataJPARepository.CourseSpringDataJPARepository;


@RestController
public class CoursesController {

	@Autowired
	private CourseSpringDataJPARepository courseRepo;
	
	@GetMapping("/courses")
	public List<Course> getAllCourses(){
		return courseRepo.findAll();
	}
	
	@GetMapping("/courses/{id}")
	public Course getCourseDetails(@PathVariable long id){
		Optional<Course> courseById = courseRepo.findById(id);
		
		if(courseById.isEmpty()) {
			throw new RuntimeException("Course not found with id " + id);
		}
		return courseById.get();
	}
	
	@PostMapping("/courses")
	public void createCourse(@RequestBody Course course) {
		courseRepo.save(course);
	}
	
	@PutMapping("/courses/{id}")
	public void updateCourse(@PathVariable long id, @RequestBody Course course) {
		courseRepo.save(course);
	}
	
	@DeleteMapping("/courses/{id}")
	public void deleteCourse(@PathVariable long id) {
		courseRepo.deleteById(id);
	}
}
