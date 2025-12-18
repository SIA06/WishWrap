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
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "SubCategories")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SubcategoriesEntity 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer sub_category_id;
    
    @Column(length=15)
    String name;
    
    @ManyToOne
    @JoinColumn(name="category_id" ,referencedColumnName = "category_id")
    CategoriesEntity category;
}
