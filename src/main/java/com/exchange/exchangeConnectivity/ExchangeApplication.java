package com.exchange.exchangeConnectivity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class ExchangeApplication {

	//private static final Logger logger = LoggerFactory.getLogger(ExchangeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ExchangeApplication.class, args);

	}

}
