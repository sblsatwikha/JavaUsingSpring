package com.in28mts.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyMathTest {

	@BeforeAll
	static void beforeAll() {
		System.out.println("BEFORE ALL");
	}
//	
	@BeforeEach
	void beforeEach() {
		System.out.println("BEFORE");
	}
	
	@AfterAll
	static void AfterAll() {
		System.out.println("AFTER ALL");
	}
	
	@AfterEach
	void afterEach() {
		System.out.println("AFTER");
	}
	
	MyMath myMath = new MyMath();
	
	@Test
	void calculateSum3Numbers() {
		assertEquals(6, myMath.calculateSum(new int[] {1,2,3}));
	}
	
	@Test
	void calculateSumEmptyArray() {
		assertEquals(0, myMath.calculateSum(new int[] {}), "Should be zero");
	}
	

}
