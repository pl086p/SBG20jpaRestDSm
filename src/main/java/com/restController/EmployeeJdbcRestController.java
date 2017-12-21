package com.restController;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeJdbcRestController {

	@Autowired
	@Qualifier("dsAjdbcBean")
	private JdbcTemplate dsAjdbc;

	@RequestMapping(value = "/jdbc/employees")
	public List<Map<String, Object>> getData() {

		String sql = " select * from employee";
		
		/*
		System.out.println("\n\n == Get Employee with Jdbc -> RestController");  
		SqlRowSet rs = dsAjdbc.queryForRowSet(sql);
        while (rs.next()) {
        	System.out.println("    - " + rs.getString("employee_name"));   
        }
        */
        
        return dsAjdbc.queryForList(sql);
	}

}

