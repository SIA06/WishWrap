package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.CategoriesEntity;
@Repository
public interface CategoriesRepo extends JpaRepository<CategoriesEntity,Integer> {

}
