package com.example.tobyspringboot;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.Test;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@UnitTest
@interface FastUnitTest {
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Test
@interface UnitTest {
}

class HelloServiceTest {

	@FastUnitTest
	void simpleHelloService(){
	    //given
		SimpleHelloService helloService = new SimpleHelloService();

		//when
		String ret = helloService.sayHello("Test");

		//then
		assertThat(ret).isEqualTo("Hello Test");
	}

	@Test
	void helloDecorator(){
	    //given
		HelloDecorator decorator = new HelloDecorator(name -> "Hello "+name);

		//when
		String ret = decorator.sayHello("Test");

		//then
		assertThat(ret).isEqualTo("*Hello Test*");
	}

}
