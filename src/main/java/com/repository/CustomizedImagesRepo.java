package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.CustomizedImagesEntity;

@Repository
public interface CustomizedImagesRepo extends JpaRepository<CustomizedImagesEntity,Integer>{

}
