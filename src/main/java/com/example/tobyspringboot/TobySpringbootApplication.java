package com.example.tobyspringboot;


import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class TobySpringbootApplication {

	public static void main(String[] args) {

		GenericWebApplicationContext applicationContext = new GenericWebApplicationContext();
		applicationContext.registerBean(HelloController.class);
		applicationContext.registerBean(SimpleHelloService.class);
		applicationContext.refresh(); // applicationContext 가 Bean Object를 만들어주는 메서드

		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();

		WebServer webServer = serverFactory.getWebServer(servletContext ->
			servletContext.addServlet("dispatcherServlet",
				new DispatcherServlet(applicationContext))
				.addMapping("/*"));
		webServer.start();
	}

}
