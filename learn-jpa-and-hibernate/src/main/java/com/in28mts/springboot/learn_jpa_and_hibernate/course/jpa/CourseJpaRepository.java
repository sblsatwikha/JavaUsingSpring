package com.in28mts.springboot.learn_jpa_and_hibernate.course.jpa;

import org.springframework.stereotype.Repository;

import com.in28mts.springboot.learn_jpa_and_hibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository{
	
	@PersistenceContext
	EntityManager entityManager;

	public void insert(Course course) {
		entityManager.merge(course);
	}
	
	public Course findById(int id) {
		return entityManager.find(Course.class, id);
	}

	public void delete(int id) {
		entityManager.remove(findById(id));
	}

}
