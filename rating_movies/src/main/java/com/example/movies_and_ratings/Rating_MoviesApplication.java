package com.example.movies_and_ratings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Rating_MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(Rating_MoviesApplication.class, args);
	}


}
