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
@Table(name ="Categories")
@FieldDefaults(level=AccessLevel.PRIVATE)
@AllArgsConstructor
@Entity
public class CategoriesEntity {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer category_id;
	
	@Column(length=15)
	String category_name;
	
	@Column(length=25)
	String description;
	
}
