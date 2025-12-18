package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.PurchaseDetailEntity;

@Repository
public interface PurchaseDetailRepo extends JpaRepository<PurchaseDetailEntity,Integer>{

}
