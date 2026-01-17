package com.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.ProductEntity;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity,Integer>
{

	List<ProductEntity> findByIsCustomized(Boolean isCustomized);
	List<ProductEntity> findByIsCustomized(Boolean isCustomized, Sort sort);

}
