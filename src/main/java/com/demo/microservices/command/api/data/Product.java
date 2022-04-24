package com.demo.microservices.command.api.data;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Product {
	@Id
	private String productId;
	private String name;
	private BigDecimal price;
	private Integer quantity;
}
