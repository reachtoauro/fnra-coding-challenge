package com.fnra.lettercominationgenerator.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LetterCombinationGenerator {

	public static void main(String[] args) {
		SpringApplication.run(LetterCombinationGenerator.class, args);
	}

}
