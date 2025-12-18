package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.OfferEntity;

@Repository
public interface OfferRepo extends JpaRepository<OfferEntity, Integer>
{

}
