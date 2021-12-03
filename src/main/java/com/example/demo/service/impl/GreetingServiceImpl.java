package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.GretingDAO;
import com.example.demo.service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService {
	
	@Autowired
	private GretingDAO greetingDao;
	
	public String showTables() {
		System.out.println(" ------------ Service -------------");
		String num = greetingDao.showTables();
		System.out.println(" ------------ Service -------------");

		return num;
	};

}
