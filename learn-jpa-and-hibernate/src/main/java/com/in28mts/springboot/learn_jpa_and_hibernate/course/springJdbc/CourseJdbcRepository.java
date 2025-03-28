package com.in28mts.springboot.learn_jpa_and_hibernate.course.springJdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28mts.springboot.learn_jpa_and_hibernate.course.Course;

@Repository
public class CourseJdbcRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	String insertQuery = 
			"""
			insert into course(id, name, author)
			values(?, ?, ?);
			""";
	
	String DeleteQuery = 
			"""
			delete from course
			where id= ?;
			""";
	
	String SelectQuery = 
			"""
			select * from course
			where id= ?;
			""";
	
	public void insert(Course course) {
		jdbcTemplate.update(insertQuery, course.getId(), course.getName(), course.getAuthor());
	}
	
	public void delete(long id) {
		jdbcTemplate.update(DeleteQuery, id);
	}
	
	public Course findById(long id) {
		return jdbcTemplate.queryForObject(SelectQuery, new BeanPropertyRowMapper<>(Course.class), id);
	}
}
