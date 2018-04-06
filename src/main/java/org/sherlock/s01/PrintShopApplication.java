package org.sherlock.s01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ImportResource(locations = "file:extension.groovy")
public class PrintShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrintShopApplication.class, args);
	}
}
