package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.PurchaseReturnDetailsEntity;

@Repository
public interface PurchaseReturnDetailsRepo extends JpaRepository<PurchaseReturnDetailsEntity,Integer>{

}
