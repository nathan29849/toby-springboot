package com.example.tobyspringboot.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController{

	private final HelloService helloService;
//	private final ApplicationContext applcationContext;
//	public HelloController(HelloService helloService, ApplicationContext applcationContext) {
//		this.helloService = helloService;
//		this.applcationContext = applcationContext;
//		System.out.println(applcationContext);
//	}


	public HelloController(HelloService helloService) {
		this.helloService = helloService;
	}

	@GetMapping("/hello")
	public String hello(String name) {
		if (name == null || name.trim().length() == 0) {
			throw new IllegalArgumentException();
		}
		return helloService.sayHello(name);
	}

//	@Override
//	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//		System.out.println(applicationContext);
//		this.applcationContext = applicationContext;
//	}
}
