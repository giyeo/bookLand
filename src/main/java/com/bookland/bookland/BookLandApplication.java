package com.bookland.bookland;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class BookLandApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookLandApplication.class, args);
	}

}
