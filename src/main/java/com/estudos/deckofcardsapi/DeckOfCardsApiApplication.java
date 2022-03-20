package com.estudos.deckofcardsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DeckOfCardsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeckOfCardsApiApplication.class, args);
	}

}
