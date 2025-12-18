package com.entity;

import java.math.BigDecimal;

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
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="PurchaseDetail")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PurchaseDetailEntity {
 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer purchasedetail_id;
	
	@ManyToOne
	@JoinColumn(name="product_id",referencedColumnName = "product_id")
	ProductEntity product;
	
	@Column(precision=5,scale=3)
	BigDecimal price;
	
	Integer qty;
	
	@ManyToOne
	@JoinColumn(name="purchase_id",referencedColumnName = "purchase_id")
	PurchaseEntity purchase;
	
	// supplier
	
}
