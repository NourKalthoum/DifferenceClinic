package com.example.difference_clinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration(exclude =
    {JpaRepositoriesAutoConfiguration.class})
@ComponentScan(basePackages = "com.nuclibrarybackstage.repository")
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class DifferenceClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(DifferenceClinicApplication.class, args);
	}

}
