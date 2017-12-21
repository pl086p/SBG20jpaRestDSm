package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// for global CORS 
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jpa.entity.Library;
import com.jpa.repository.LibraryRepository;

@SpringBootApplication
public class Application {

	//@Autowired
	//DataSource dataSource;

	@Autowired
	@Qualifier("dsAjdbcBean")
	JdbcTemplate jdbcA;
	
	@Autowired
	@Qualifier("dsBjdbcBean")
	JdbcTemplate jdbcB;
	
	//@Autowired
	//LibraryRepository libraryRepository;

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    /*
    // get data from JPA 
    @Bean
    public CommandLineRunner getLibraryFromJpa(LibraryRepository libraryRepository) {
    	return (args) -> {

    		System.out.println("=== ");
    		System.out.println("=== get data from JPA - show libraryRepository to console");
    		
    		for (Library library : libraryRepository.findAll()) {
    	   		System.out.println("     - id = " + library.getId() + ", name = " + library.getName() );
    		}
    		
    		System.out.println("=== get data from JPA - show libraryRepository to log (displayed on console)");
    		for (Library library : libraryRepository.findAll()) {
    			log.info(library.toString());
    		}    		
    	};
    }
    */
    
    // get data from JDBC 
    @Bean
    public CommandLineRunner getDataFromJdbc() {
    	return (args) -> {
	
			String sql;
			SqlRowSet rs;
			
			System.out.println("\n\n == Get dsA.Employee with Jdbc -> RestController"); 
			sql = "select * from employee";
			rs = jdbcA.queryForRowSet(sql);
	        while (rs.next()) {
	        	System.out.println("    - " + rs.getString("employee_name"));   
	        }
	        
			
			System.out.println("\n\n == Get dsB.Parent with Jdbc -> RestController");  
			sql = "select * from parent";
			rs = jdbcB.queryForRowSet(sql);
	        while (rs.next()) {
	        	System.out.println("    - " + rs.getString("name"));   
	        }	        
    		  		
    	};
    }    

}
