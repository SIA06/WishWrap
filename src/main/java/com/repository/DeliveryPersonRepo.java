package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.DeliveryPersonEntity;

@Repository
public interface DeliveryPersonRepo extends JpaRepository<DeliveryPersonEntity,Integer>{

}
