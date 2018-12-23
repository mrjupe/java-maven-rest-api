package com.bootcamp.dao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bootcamp.dao.CustomerDao;
import com.bootcamp.impl.CustomerDaoImpl;

@Configuration
public class DaoSpringConfig {

	@Bean
	public CustomerDao customerDao() {
		return new CustomerDaoImpl();
	}
}
