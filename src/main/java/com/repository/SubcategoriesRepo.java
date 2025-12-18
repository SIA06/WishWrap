package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.SubcategoriesEntity;
@Repository

public interface SubcategoriesRepo extends JpaRepository<SubcategoriesEntity,Integer>{

}
