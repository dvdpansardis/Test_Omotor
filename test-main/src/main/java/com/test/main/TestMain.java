/*
 * Product: OMotor
 * Copyright (C) 2017 OMotor. All Rights Reserved.
 */
package com.test.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Start da aplicação
 * @author esdrastavares
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.test.api", "com.test.service"})
@EntityScan(basePackages = "com.test.model")
@EnableJpaRepositories(basePackages = "com.test.repository")
public class TestMain {

	public static void main(String[] args) {
		SpringApplication.run(TestMain.class, args);
	}

}
