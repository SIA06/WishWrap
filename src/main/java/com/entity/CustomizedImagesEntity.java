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

@Data
@Entity
@Table(name = "CustomizedImages")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomizedImagesEntity {  
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    Integer imageId;

    @ManyToOne
    @JoinColumn(name = "customize_id",
                referencedColumnName = " customize_id")
    
    CustomizeEntity customize;
    
    
    @Column( length = 25)
    String imageOne;

    @Column(length = 25)
    String imageTwo;

    @Column(length = 25)
    String imageThree;
	
}
