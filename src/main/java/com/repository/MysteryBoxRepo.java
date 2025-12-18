package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.MysteryBoxEntity;

@Repository
public interface MysteryBoxRepo extends JpaRepository<MysteryBoxEntity, Integer>
{

}
