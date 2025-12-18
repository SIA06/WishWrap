package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.SupplierEntity;

@Repository
public interface SupplierRepo extends JpaRepository<SupplierEntity, Integer>
{

}
