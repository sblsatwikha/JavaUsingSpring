package com.in28min.learn_spring_framework_businessCalc;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.in28min.learn_spring_framework_businessCalcService.BusinessCalculationService;


@Configuration
@ComponentScan("com.in28min.learn_spring_framework_businessCalcService")
public class BusinessCalculation {

	public static void main(String[] args) {
		try (// TODO Auto-generated method stub
		var context = new AnnotationConfigApplicationContext(BusinessCalculation.class)) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(context.getBean(BusinessCalculationService.class).findMax());
		}
	}

}
