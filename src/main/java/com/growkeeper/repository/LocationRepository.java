package com.growkeeper.repository;

import com.growkeeper.domain.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends CrudRepository<Location, String> {
}
