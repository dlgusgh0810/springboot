package com.Lect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.Lect.week02")
@ComponentScan(basePackages = "com.Lect.week03")
@ComponentScan(basePackages = "com.Lect.week04")
public class SpringLect1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringLect1Application.class, args);
	}

}
