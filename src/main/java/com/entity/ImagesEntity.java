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
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="Images")
public class ImagesEntity {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
     Integer image_id;

    @Column( length = 100)
     String image_name;
    

    @Column( length = 100)
     String image_url;
    

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
     ProductEntity product;

}
