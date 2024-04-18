package com.cardealer.car.controller;

import com.cardealer.car.model.Cars;
import com.cardealer.car.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cars")
public class CarsController {

    @Autowired
    CarsService carsService;

    @GetMapping("/{id}")
    public ResponseEntity<Cars> getCar(@PathVariable Long id) {
        return new ResponseEntity<>(carsService.getCars(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cars>> getAllCars() {
        return new ResponseEntity<>(carsService.getAllCars(), HttpStatus.OK);
    }

//    @PutMapping("/customer/{customerId}/car/{carId}")
//    public ResponseEntity<Cars> addCarToCustomer(@PathVariable Long customerId, @PathVariable Long carId) {
//            return new ResponseEntity<>(carsService.addCarToCustomer(customerId, carId), HttpStatus.OK);
//    }

    @PostMapping("/car")
    public ResponseEntity<Cars> saveCar(@RequestBody Cars cars, Long carId) {
        return new ResponseEntity<>(carsService.saveCar(cars, carId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCar(@PathVariable Long id){
        carsService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
