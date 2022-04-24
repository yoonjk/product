package com.demo.microservices.command.api.commands;

import java.math.BigDecimal;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CreateProductCommand {
	@TargetAggregateIdentifier
	private String productId;
	private String name;
	private BigDecimal price;
	private Integer quantity;
	
	@Builder
	public CreateProductCommand(String productId,
			String name, BigDecimal price, Integer quantity) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
}
