package com.entity;

import java.time.LocalDateTime;

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
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="Sales")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
public class SalesEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer sales_id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	UserEntity user;
	
	@ManyToOne
	@JoinColumn(name="offer_id")
	OfferEntity offer;
	
	@ManyToOne
	@JoinColumn(name="area_id")
	AreaEntity area;
	
	@ManyToOne
	@JoinColumn(name="address_id")
	AddressEntity address;
	
	Double shipping_charge;
	
	@DateTimeFormat(pattern = "DD-MM-YYYY")
	LocalDateTime s_date;
	
	@Column(length=10)
	String status;
	
	Float total_amount;
	
	@Column(length=10)
	String payment_method;
	
	@Column(length=15)
	String payment_status;
	
}
