package com.growkeeper.repository;

import com.growkeeper.domain.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
    @Override
    List<Event> findAll();
}
