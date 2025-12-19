package com.entity;

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

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="Feedback")
public class FeedbackEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        
    Integer feedback_id;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
     UserEntity user;

    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "product_id")
     ProductEntity product;

    @Column(length = 255)
     String description;

     Integer rating;

    @DateTimeFormat(pattern="dd-mm-yyyy")
     LocalDate ratingDate;
}
