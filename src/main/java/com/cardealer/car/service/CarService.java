package com.cardealer.car.service;

import com.cardealer.car.entity.Car;

import java.util.List;

public interface CarService {

    Car getCars(Long id);
    Car saveCar(Car cars, Long carId);
    Car updateCar(Long id, Car updateCar);
    void deleteCar(Long id);

//    Cars addCarToCustomer(Long customerId, Long carId);
    List<Car> getAllCars();
}
