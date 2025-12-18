package com.entity;

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
@Table(name="Area")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
public class AreaEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer area_id;
	
	@Column(length=15)
	String name;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	CityEntity city;
}
