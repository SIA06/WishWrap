package com.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name="Purchase")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PurchaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer purchase_id;
	
    @DateTimeFormat(pattern="dd-mm-yyyy")
    LocalDate purchaseDate;
	
	@ManyToOne
	@JoinColumn(name="supplier_id",referencedColumnName = "supplier_id")
	SupplierEntity supplier;
	
}
