package com.example.tobyspringboot;

import java.util.Objects;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController{

	private final HelloService helloService;
	private final ApplicationContext applcationContext;

	public HelloController(HelloService helloService, ApplicationContext applcationContext) {
		this.helloService = helloService;
		this.applcationContext = applcationContext;
		System.out.println(applcationContext);
	}

	@GetMapping("/hello")
	public String hello(String name) {
		return helloService.sayHello(Objects.requireNonNull(name));
	}

//	@Override
//	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//		System.out.println(applicationContext);
//		this.applcationContext = applicationContext;
//	}
}
