package com.entity;

import java.math.BigDecimal;

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
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="Product")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer product_id;
	
    @Column(length=25)
    String product_name;
    
    @Column(length=20)
    String description;
    
    @Column(name = "price", precision = 10, scale = 2) 
    BigDecimal price;
    
    @ManyToOne
    @JoinColumn(name="sub_category_id" , referencedColumnName = "sub_category_id")
    SubcategoriesEntity  subcategory;
    
    @ManyToOne
    @JoinColumn(name="brand_id" , referencedColumnName = "brand_id")
    BrandEntity brand;
    
    Integer stock;
    
    Boolean isCustomized;
}
