package com.in28mts.springboot.learn_jpa_and_hibernate.course.springJpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28mts.springboot.learn_jpa_and_hibernate.course.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Integer> {
	List<Course> findByAuthor(String author);
	List<Course> findByName(String name);
}
