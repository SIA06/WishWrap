package com.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name="Offer")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
public class OfferEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer offer_id;
	
	Integer offer_type_id;
	
	@Column(length=25)
	String description;
	
	@DateTimeFormat(pattern = "DD-MM-YYYY")
	LocalDate start_date;
	
	@DateTimeFormat(pattern = "DD-MM-YYYY")
	LocalDate end_date;
	
	Float discount;
}
