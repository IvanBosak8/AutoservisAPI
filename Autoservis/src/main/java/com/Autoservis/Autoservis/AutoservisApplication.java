package com.Autoservis.Autoservis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableJpaRepositories("com.Autoservis.Autoservis.repositories")
@EntityScan("com.Autoservis.Autoservis.entities")
public class AutoservisApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoservisApplication.class, args);
	}

}
