package com.in28mts.learn_spring_boot.courses.springdataJPARepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28mts.learn_spring_boot.courses.bean.Course;

public interface CourseSpringDataJPARepository extends JpaRepository<Course, Long> {

}
