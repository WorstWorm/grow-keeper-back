package com.growkeeper.repository;

import com.growkeeper.domain.Weather;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface WeatherRepository extends CrudRepository<Weather, Integer> {
    @Override
    List<Weather> findAll();
}
