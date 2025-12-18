package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.ShopEntity;

@Repository
public interface ShopRepo extends JpaRepository<ShopEntity, Integer>
{

}
