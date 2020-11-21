package com.hackathon.mobileconnection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling

@SpringBootApplication
public class MobileconnectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileconnectionApplication.class, args);
	}

}
