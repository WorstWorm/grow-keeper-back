package com.growkeeper.repository;

import com.growkeeper.domain.Weather;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface WeatherRepository extends CrudRepository<Weather, Integer> {
    @Override
    List<Weather> findAll();

    Optional<Weather> findByWeatherTime(LocalDateTime time);

    void deleteByWeatherTime(LocalDateTime time);
}
