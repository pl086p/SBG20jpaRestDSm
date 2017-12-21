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
public class DataSourceB_Configuration {
	@Bean(name = "dsBbean")								// create bean dsAbean
	@ConfigurationProperties(prefix = "spring.dsB")		// load properties with prefix to this bean
	public DataSource dsB() {
		return DataSourceBuilder.create().build();		// return data source dsA object 
	}

	@Bean(name = "dsBjdbcBean")
	public JdbcTemplate dsBjdbcTemplate(@Qualifier("dsBbean") DataSource ds) {		// accept dsAbean as qualifier
		return new JdbcTemplate(ds);												// return jdbcTemplate object of dsAbean 
	}

}