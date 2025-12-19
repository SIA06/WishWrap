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

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="Wishlist")
public class WishListEntity 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer wishlist_id;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
     UserEntity user;
	
	@ManyToOne
    @JoinColumn(name = "product_id" )
     ProductEntity product;
	
	@DateTimeFormat(pattern="dd-mm-yyyy")
     LocalDate w_date;
}
