package com.demo.microservices.command.api.aggregate;

import java.math.BigDecimal;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.demo.microservices.command.api.commands.CreateProductCommand;
import com.demo.microservices.command.api.events.ProductCreatedEvent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aggregate
public class ProductAggregate {
	@AggregateIdentifier
	private String productId;
	private String name;
	private BigDecimal price;
	private Integer quantity;
	
	public ProductAggregate() {}
	
	@CommandHandler
	public ProductAggregate(CreateProductCommand createProductCommand) {
		// You can perform all the validation
		log.info("2.CommandHandler:{}",	createProductCommand);
		ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();

		BeanUtils.copyProperties(createProductCommand, productCreatedEvent);
		AggregateLifecycle.apply(productCreatedEvent);
	}
	
	@EventSourcingHandler
	public void on(ProductCreatedEvent productCreatedEvent) {
		log.info("3.EventSourcingHandler:{}",productCreatedEvent);
		this.productId = productCreatedEvent.getProductId();
		this.name = productCreatedEvent.getName();
		this.price = productCreatedEvent.getPrice();
		this.quantity = productCreatedEvent.getQuantity();
	}
}
