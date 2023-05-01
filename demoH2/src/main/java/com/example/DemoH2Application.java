package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@EnableAutoConfiguration
//@ComponentScan(basePackages ={"com.example.demo"})
//@EntityScan("com.example.demo.entities")
//@EnableJpaRepositories("com.example.demo.repositories")
@SpringBootApplication
public class DemoH2Application {
	public static void main(String[] args) {
		SpringApplication.run(DemoH2Application.class, args);
	}

}
