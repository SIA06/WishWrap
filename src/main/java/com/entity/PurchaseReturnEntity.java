package com.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name="PurchaseReturn")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PurchaseReturnEntity {
      
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer purchase_ret_id;
	
	 @ManyToOne
	    @JoinColumn(name = "purchase_id", nullable = false)
	   PurchaseEntity purchase;
	 
	 @DateTimeFormat(pattern="dd-mm-yyyy")
	 LocalDate returnDate;
	 
	 @Column(precision=5,scale=3)
	 BigDecimal returnAmount;
	 
	 String reason_to_ret;
}
