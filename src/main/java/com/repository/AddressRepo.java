package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.AddressEntity;

@Repository
public interface AddressRepo extends JpaRepository<AddressEntity, Integer>
{

}
