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
@Table(name="Mystery_Box")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
public class MysteryBoxEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer mystery_id;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	ProductEntity product;
	
	Float price;
	
	Integer item_qty;
}
