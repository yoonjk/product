package com.demo.microservices.command.api.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ProductDto {
	private String name;
	private BigDecimal price;
	private Integer quantity;
}
