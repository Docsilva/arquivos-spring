package com.generation.lojagame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.generation.lojagame.repository.CategoriaRepository;


@SpringBootApplication (exclude = {DataSourceAutoConfiguration.class })
public class LojagameApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojagameApplication.class, args);
	}

}
