package com.example.tobyspringboot;


import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class TobySpringbootApplication {

	// 팩토리 메서드를 통해 빈 오브젝트를 만든다.
	@Bean
	public HelloController helloController(HelloService helloService) {
		return new HelloController(helloService);
	}

	@Bean
	public HelloService helloService() {
		return new SimpleHelloService();
	}

	public static void main(String[] args) {

		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext(){
			@Override
			protected void onRefresh() {
				super.onRefresh();
				ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
				WebServer webServer = serverFactory.getWebServer(servletContext ->
					servletContext.addServlet("dispatcherServlet",
							new DispatcherServlet(this))
						.addMapping("/*"));
				webServer.start();
			}
		};
		applicationContext.register(TobySpringbootApplication.class);
		applicationContext.refresh(); // applicationContext 가 Bean Object를 만들어주는 메서드


	}

}
