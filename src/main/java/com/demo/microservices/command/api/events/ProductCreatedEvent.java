package com.demo.microservices.command.api.events;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@NoArgsConstructor
public class ProductCreatedEvent {
	private String productId;
	private String name;
	private BigDecimal price;
	private Integer quantity;
	
	@Builder
	public ProductCreatedEvent(String productId,
			String name, BigDecimal price, Integer quantity) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
}
