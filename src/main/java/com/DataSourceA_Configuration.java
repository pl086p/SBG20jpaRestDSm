//https://www.infoq.com/articles/Multiple-Databases-with-Spring-Boot

package com;


import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataSourceA_Configuration {
	@Bean(name = "dsAbean")								// create bean dsAbean
	@Primary											// tell springboot to use this bean as primary bean
	@ConfigurationProperties(prefix = "spring.dsA")		// load properties with prefix to this bean
	public DataSource dsA() {
		return DataSourceBuilder.create().build();		// return data source dsA object 
	}

	@Bean(name = "dsAjdbcBean")
	public JdbcTemplate dsAjdbcTemplate(@Qualifier("dsAbean") DataSource ds) {		// accept dsAbean as qualifier
		return new JdbcTemplate(ds);												// return jdbcTemplate object of dsAbean 
	}

}