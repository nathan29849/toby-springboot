package com.example.tobyspringboot.config;

import com.example.tobyspringboot.config.EnableMyAutoConfig;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@EnableMyAutoConfig
public @interface MySpringBootApplication {

}
