package com.cardealer.car.repository;

import com.cardealer.car.model.Cars;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends CrudRepository<Cars, Long> {
}
