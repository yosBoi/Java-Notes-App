package com.nagarro.notes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableScheduling
@ComponentScan({"com.nagarro.notes"})
public class NotesApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(NotesApplication.class, args);
		
		
		
	}

}
