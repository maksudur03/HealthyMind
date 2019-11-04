package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.demo.exception.FileStorageProperties;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableConfigurationProperties({
    FileStorageProperties.class
})

public class HealthMindApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthMindApplication.class, args);
	}

}
