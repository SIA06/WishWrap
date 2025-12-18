package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.entity.CityEntity;

@Repository
public interface CityRepo extends JpaRepository<CityEntity, Integer>
{

}
