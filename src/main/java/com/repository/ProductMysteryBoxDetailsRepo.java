package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.ProductMysteryBoxDetailsEntity;

@Repository
public interface ProductMysteryBoxDetailsRepo extends JpaRepository<ProductMysteryBoxDetailsEntity, Integer> 
{

}
