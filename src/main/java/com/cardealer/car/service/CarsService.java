package com.cardealer.car.service;

import com.cardealer.car.model.Cars;

import java.util.List;

public interface CarsService {

    Cars getCars(Long id);
    Cars saveCar(Cars cars, Long carId);
    void deleteCar(Long id);

//    Cars addCarToCustomer(Long customerId, Long carId);
    List<Cars> getAllCars();
}
