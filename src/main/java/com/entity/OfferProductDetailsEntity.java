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
@Table(name="Offer_Product_Details")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
public class OfferProductDetailsEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer offer_product_id;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	ProductEntity product;
	
	@ManyToOne
	@JoinColumn(name="offer_id")
	OfferEntity offer;
	
	
}
