package com.producto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.commons.entities"})
public class MsProductoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProductoApplication.class, args);
	}

}
