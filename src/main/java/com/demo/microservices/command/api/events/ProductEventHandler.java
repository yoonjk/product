package com.demo.microservices.command.api.events;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.microservices.command.api.data.Product;
import com.demo.microservices.command.api.data.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ProductEventHandler {
	
	@Autowired
	private ProductRepository productRepositry;

	@EventHandler
	public void on(ProductCreatedEvent productCreatedEvent) {
		Product product = new Product();
		
		BeanUtils.copyProperties(productCreatedEvent, product);
		
		log.info("4.save Product:{}", product);
		productRepositry.save(product);
		
	}
}
