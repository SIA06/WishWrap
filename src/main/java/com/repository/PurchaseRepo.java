package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.PurchaseEntity;

@Repository
public interface PurchaseRepo extends JpaRepository<PurchaseEntity,Integer>{

}
