package com.demo.microservices.command.api.controller;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.microservices.command.api.commands.CreateProductCommand;
import com.demo.microservices.command.api.model.ProductDto;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/products")
public class ProductCommandController {
	@Autowired
	private CommandGateway commandGateway;
	@PostMapping
	public String addProduct(@RequestBody ProductDto product) {
		CreateProductCommand createProductCommand = 
				CreateProductCommand.builder()
					.productId(UUID.randomUUID().toString())
					.name(product.getName())
					.price(product.getPrice())
					.quantity(product.getQuantity())
					.build();
			
		log.info("1.addProduct:{}", createProductCommand);
		String result = commandGateway.sendAndWait(createProductCommand);
		
		return result;
	}
}
