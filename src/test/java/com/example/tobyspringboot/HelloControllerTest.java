package com.example.tobyspringboot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class HelloControllerTest {

	@Test
	void helloController(){
	    //given
		HelloController helloController = new HelloController(name -> "Hello "+name);

		//when
		String ret = helloController.hello("Test");

		//then
		assertThat(ret).isEqualTo("Hello Test");
	}

	@Test
	void failsHelloController(){
		//given
		HelloController helloController = new HelloController(name -> "Hello "+name);

		//when & then
		assertThatThrownBy(() -> helloController.hello(null))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> helloController.hello("    "))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
