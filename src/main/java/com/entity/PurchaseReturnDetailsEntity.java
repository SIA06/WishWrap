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
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="PurchaseReturnDetails")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PurchaseReturnDetailsEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer purchaseReturnDetailsId;
	
	Integer qty;
	
	@ManyToOne
	@JoinColumn(name="product_id",referencedColumnName = "product_id")
	ProductEntity product;
	
	@ManyToOne
	@JoinColumn(name="purchase_ret_id",referencedColumnName = "purchase_ret_id")
	PurchaseReturnEntity purchase_return;
	
}


