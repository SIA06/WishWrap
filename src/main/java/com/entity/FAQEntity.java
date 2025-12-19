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
@Table(name="FAQ")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
public class FAQEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer faq_id;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	ProductEntity product;
	
	@Column(length=15)
	String faq_question;
	
	@Column(length=25)
	String faq_answers;
	
}
