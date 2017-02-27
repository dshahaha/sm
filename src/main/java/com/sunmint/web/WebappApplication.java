package com.sunmint.web;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class WebappApplication {
	private Logger log = Logger.getLogger(WebappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args);
	}

	@Bean
	public CommandLineRunner lineRunner(UserRepository repository) {
		return (args) -> {
			User user = new User("Garfield Smith","garfield@sunmint.com","pass","admin");
			repository.save(user);

			log.info("Saved user - userName " + user.getEmail());

			user = new User("Andres Arango","andres@sunmint.com","pass","admin");
			repository.save(user);

			log.info("Saved user - userName " + user.getEmail());

			user = new User("Administration","admin@sunmint.com","pass","admin");
			repository.save(user);

			log.info("Saved user - userName " + user.getEmail());
		};
	}
}