package com.growkeeper.repository;

import com.growkeeper.domain.Plant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantRepository extends CrudRepository<Plant, String> {
    @Override
    List<Plant> findAll();
}
