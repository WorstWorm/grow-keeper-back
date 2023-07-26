package com.growkeeper.repository;

import com.growkeeper.domain.Area;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaRepository extends CrudRepository<Area, Integer> {
    @Override
    List<Area> findAll();
}
