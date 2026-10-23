package com.gremio.agenda_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.gremio")
@EntityScan("com.gremio.model")
@EnableJpaRepositories("com.gremio.repository")
public class AgendaWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaWebApplication.class, args);
	}

}
