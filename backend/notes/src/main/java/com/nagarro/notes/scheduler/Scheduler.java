package com.nagarro.notes.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.nagarro.notes.service.UserService;

@Component
public class Scheduler {
	
	@Autowired
	private UserService userService;
	
	//@Scheduled(cron = "0 0 * * * *")
	@Scheduled(cron = "*/5 * * * * *")
	public void cronJob() {
		System.out.println("cron");
		userService.deleteHourly();
	}
}
