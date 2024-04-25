package com.cardealer.car.controller;

import com.cardealer.car.entity.Car;
import com.cardealer.car.service.CarService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cars")
@Tag(name = "Cars")
public class CarsController {

    @Autowired
    CarService carsService;

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCar(@PathVariable Long id) {
        return new ResponseEntity<>(carsService.getCars(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars() {
        return new ResponseEntity<>(carsService.getAllCars(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car car) {
        return new ResponseEntity<>(carsService.updateCar(id, car), HttpStatus.OK);
    }


    @PostMapping("/car")
    public ResponseEntity<Car> saveCar(@RequestBody Car cars, Long carId) {
        return new ResponseEntity<>(carsService.saveCar(cars, carId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCar(@PathVariable Long id){
        carsService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
