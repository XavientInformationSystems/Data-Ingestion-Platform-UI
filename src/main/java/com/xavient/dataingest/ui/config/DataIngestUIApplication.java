
package com.xavient.dataingest.ui.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.xavient" })
public class DataIngestUIApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataIngestUIApplication.class, args);
	}

}
