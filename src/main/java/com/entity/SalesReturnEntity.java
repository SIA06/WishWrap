package com.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="Sales_Return")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
public class SalesReturnEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer sales_return_id;
	
	@DateTimeFormat(pattern="DD-MM-YYYY")
	LocalDate sales_ret_date;
	
	@OneToOne
	@JoinColumn(name="sales_id")
	SalesEntity sales;
}
