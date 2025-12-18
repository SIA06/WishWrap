package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="Sales_Details")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor

public class SalesDetailsEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer sales_id;
	
	Integer qty;
	
	Float price;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	ProductEntity product;
}
