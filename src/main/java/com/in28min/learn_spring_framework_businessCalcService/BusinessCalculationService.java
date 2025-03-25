package com.in28min.learn_spring_framework_businessCalcService;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BusinessCalculationService {
	DataService dataService;
	public BusinessCalculationService(@Qualifier("mySQLDataService") DataService dataService) {
		this.dataService = dataService;
	}
	public int findMax() {
		return Arrays.stream(dataService.retriveData()).max().orElse(0);
	}
}
