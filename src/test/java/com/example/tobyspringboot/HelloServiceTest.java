package com.example.tobyspringboot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class HelloServiceTest {

	@Test
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
