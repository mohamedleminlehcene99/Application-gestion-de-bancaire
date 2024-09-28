package com.lehcene.app_bancaire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AppBancaireApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppBancaireApplication.class, args);
	}

}
