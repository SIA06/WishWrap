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
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="DeliveryPerson")
public class DeliveryPersonEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Integer delivery_person_id;

    @Column( length = 50)
     String name;

    @Column(length = 15)
    String phoneNo;

  //  @ManyToOne
   // @JoinColumn(name = "user_id",referencedColumnName = "user_id")
   //  UserEntity user;
}
