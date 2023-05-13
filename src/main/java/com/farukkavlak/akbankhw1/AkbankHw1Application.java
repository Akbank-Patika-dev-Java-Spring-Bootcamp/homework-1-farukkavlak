package com.farukkavlak.akbankhw1;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Akbank Bootcamp HW1", version = "1.0", description = "Akbank Bootcamp HW1 API"))
public class AkbankHw1Application {

	public static void main(String[] args) {
		SpringApplication.run(AkbankHw1Application.class, args);
	}


}
