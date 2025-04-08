package com.example.userBorrowBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.userBorrowBook.repository")
@EntityScan("com.example.userBorrowBook.model")
@EnableJpaAuditing
public class UserBorrowBookBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserBorrowBookBackApplication.class, args);
	}

}
