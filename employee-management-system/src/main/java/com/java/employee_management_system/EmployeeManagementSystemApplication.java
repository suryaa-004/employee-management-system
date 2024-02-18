package com.java.employee_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "com.java.employee_management_system")
@EntityScan("com.java.employee_management_system.entity")

public class EmployeeManagementSystemApplication {

	public static void main(String[] args) {

		SpringApplication.run(EmployeeManagementSystemApplication.class, args);
	}

}
