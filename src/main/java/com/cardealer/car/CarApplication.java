package com.cardealer.car;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class CarApplication{

	public static void main(String[] args) {
		SpringApplication.run(CarApplication.class, args);
	}

}
