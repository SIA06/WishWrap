package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.OfferProductDetailsEntity;

@Repository
public interface OfferProductDetailsRepo extends JpaRepository<OfferProductDetailsEntity, Integer>
{

}
