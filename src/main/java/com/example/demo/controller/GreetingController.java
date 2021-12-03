package com.example.demo.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Greeting;
import com.example.demo.service.GreetingService;

import io.micrometer.core.annotation.Timed;

@RestController
public class GreetingController {

	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	private GreetingService greetingService;

	@GetMapping("/greeting")
	@Timed(value = "greeting.time", description = "Time taken to return greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		String num = null;
		try {
			num = greetingService.showTables();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return new Greeting(counter.incrementAndGet(), num);
	}
}
