package com.in28min.learn_spring_framework.advanced;

import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//Default is Singleton
@Component
class NormalClass{
	
}

@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class ScopedProtoTypeClass{
	
}

@Configuration
@ComponentScan
public class ScopeApplication {

	public static void main(String[] args) {
		try (// TODO Auto-generated method stub
		var context = new AnnotationConfigApplicationContext(ScopeApplication.class)) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
//			one instance per Spring IOC container - singleton (default)
			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(NormalClass.class));
			
//			many instances per Spring IOC container - prototype
			System.out.println(context.getBean(ScopedProtoTypeClass.class));
			System.out.println(context.getBean(ScopedProtoTypeClass.class));
			System.out.println(context.getBean(ScopedProtoTypeClass.class));
			System.out.println(context.getBean(ScopedProtoTypeClass.class));
			
		}
	}

}