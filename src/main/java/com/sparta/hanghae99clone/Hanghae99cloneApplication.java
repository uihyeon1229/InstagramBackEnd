package com.sparta.hanghae99clone;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.boot.builder.SpringApplicationBuilder;

@EnableJpaAuditing
@SpringBootApplication
public class Hanghae99cloneApplication {

	public static final String APPLICATION_LOCATIONS = "spring.config.location="
		+ "classpath:application.properties,"
		+ "classpath:aws.yml";

	public static void main(String[] args) {
		new SpringApplicationBuilder(Hanghae99cloneApplication.class)
			.properties(APPLICATION_LOCATIONS)
			.run(args);
	}
}
