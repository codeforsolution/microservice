package com.codeforsolution.product.service.productservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
class ProductServiceApplicationTests {

	static final MySQLContainer MY_SQL_CONTAINER;

	static {
		MY_SQL_CONTAINER = new MySQLContainer("mysql:latest");
		MY_SQL_CONTAINER.start();
	}

	@DynamicPropertySource
	static void configureTestProperties(DynamicPropertyRegistry registry){
		registry.add("spring.datasource.url",() -> MY_SQL_CONTAINER.getJdbcUrl());
		registry.add("spring.datasource.username",() -> MY_SQL_CONTAINER.getUsername());
		registry.add("spring.datasource.password",() -> MY_SQL_CONTAINER.getPassword());
		registry.add("spring.jpa.hibernate.ddl-auto",() -> "create");

	}

	@Test
	void contextLoads() {
	}

}
