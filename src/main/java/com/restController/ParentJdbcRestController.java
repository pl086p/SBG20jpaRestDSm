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
public class ParentJdbcRestController {

	@Autowired
	@Qualifier("dsBjdbcBean")
	private JdbcTemplate dsBjdbc;

	@RequestMapping(value = "/jdbc/parents")
	public List<Map<String, Object>> getData() {

		String sql = " select * from parent";
		
		/*
		System.out.println("\n\n == Get Parent with Jdbc -> RestController");  
		SqlRowSet rs = dsBjdbc.queryForRowSet(sql);
        while (rs.next()) {
        	System.out.println("    - " + rs.getString("name"));   
        }
        */
        
        return dsBjdbc.queryForList(sql);
	}

}

