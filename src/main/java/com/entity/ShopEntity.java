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
@Table(name="Shop_Details")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
public class ShopEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer shop_id;
	
	@Column(length=10)
	String shop_name;
	
	@Column(length=25)
	String address;
	
	@Column(length=20)
	String phone_no;
	
	@Column(length=50)
	String email;
	
}
