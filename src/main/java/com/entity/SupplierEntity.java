package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="Supplier")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
public class SupplierEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer supplier_id;
	
	@Column(length=10)
	String name;
	
	@Column(length=15)
	String brand_name;
	
	@Column(length=20)
	String contact_no;
	
	@Column(length=15)
	String email;
}
