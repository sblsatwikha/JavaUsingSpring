package com.in28mts.junit;

public class MyMath {
	public int calculateSum(int[] numbers) {
		int sum=0;
		for(int number: numbers) {
			sum += number;
		}
		return sum;
	}
}
