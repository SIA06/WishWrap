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
@Table(name="Address")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
public class AddressEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer address_id;
	
	@ManyToOne
	@JoinColumn(name="area_id")
	AreaEntity area;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	UserEntity user;
	
	@Column(length=100)
	String other_address1;
	
	@Column(length=100)
	String other_address2;
}
