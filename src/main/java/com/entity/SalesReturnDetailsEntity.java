package com.entity;

import jakarta.persistence.Column;
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
@Table(name="Sales_Return_Details")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
public class SalesReturnDetailsEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer salesdetails_id;
	
	@ManyToOne
	@JoinColumn(name="sales_return_id")
	SalesReturnEntity salesReturn;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	ProductEntity product;
	
	Integer qty;
	
	@Column(length=25)
	String reason;
}
