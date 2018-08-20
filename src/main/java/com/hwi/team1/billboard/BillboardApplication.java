package com.hwi.team1.billboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.hwi" })
public class BillboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillboardApplication.class, args);
	}
}
