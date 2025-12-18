package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.WishListEntity;

@Repository
public interface WishListRepo extends JpaRepository<WishListEntity,Integer>{

}
