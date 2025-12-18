package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.ProductImageEntity;

@Repository
public interface CustomizeRepo extends JpaRepository<ProductImageEntity, Integer> {

}
