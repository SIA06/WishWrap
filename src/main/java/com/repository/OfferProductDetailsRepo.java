package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferProductDetailsRepo extends JpaRepository<OfferProductDetailsRepo, Integer>
{

}
