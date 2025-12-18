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

@Data
@Table(name ="Brand")
@FieldDefaults(level=AccessLevel.PRIVATE)
@AllArgsConstructor
@Entity
public class BrandEntity {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer brand_id;
	
	@Column(length=15)
	String brand_name;
	
	@Column(length=15)
	String description;
}
