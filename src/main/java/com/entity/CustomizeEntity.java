package com.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

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
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Customize")
public class CustomizeEntity {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	 Integer customize_id;
	 
     @ManyToOne
     @JoinColumn(name="product_id" , referencedColumnName = "product_id")
     ProductEntity products;
     
     @ManyToOne
     @JoinColumn(name="sales_id" , referencedColumnName = "sales_id")
     SalesEntity sales;
     
     @Column(length=25)
     String description;
   
     @Column( length = 25)
     String image;

     Integer qty;

     @Column( precision = 5, scale = 3)
     BigDecimal price;                

     @DateTimeFormat(pattern = "yyyy-MM-dd")   
     LocalDate cdate;       

     @Column(columnDefinition = "TINYINT(1)")
     Boolean isAccepted;      
}
