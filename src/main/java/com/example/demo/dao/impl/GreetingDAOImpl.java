package com.example.demo.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.GretingDAO;

@Repository
public class GreetingDAOImpl implements GretingDAO {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public String showTables() {
		System.out.println("\n>>>>>> Dentro de DAO <<<<<<<<");
		//String sql = "SELECT COUNT(*) FROM banco";
		String sql = "SELECT count(*) FROM SCC_MX_LOG_CGA_ARCH_DRO";
		
		int num = jdbc.queryForObject(sql, Integer.class);
		
		System.out.format("Hay %s registro en la tabla", num);
		
		System.out.println("\n>>>>>> Fuera de DAO <<<<<<<<");
		return String.valueOf(num);
	}

}
