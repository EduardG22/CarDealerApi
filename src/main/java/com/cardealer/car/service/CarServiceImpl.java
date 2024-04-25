package com.cardealer.car.service;

import com.cardealer.car.exceptions.EntityNotFoundException;
import com.cardealer.car.entity.Car;
import com.cardealer.car.repository.CarRepository;
import com.cardealer.car.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Car getCars(Long id) {
        Optional<Car> cars = carRepository.findById(id);
        return unwrapCar(cars,id);
    }


    @Override
    public Car saveCar(Car cars, Long carId) {
        return carRepository.save(cars);
    }

    @Override
    public Car updateCar(Long id, Car updateCar) {
        Car car = carRepository.findById(id).get();
        car.setColor(updateCar.getColor());
        car.setType(updateCar.getType());
        car.setModel(updateCar.getModel());
        car.setRegistration(updateCar.getRegistration());
        car.setIsAvailable(updateCar.getIsAvailable());
        return carRepository.save(car);
    }

    @Override
    public void deleteCar(Long id) {
      carRepository.deleteById(id);
    }

    @Override
    public List<Car> getAllCars() {
        return (List<Car>) carRepository.findAll();
    }

//    @Override
//    public Cars addCarToCustomer(Long customerId, Long carId) {
//        Cars car = getCars(carId);
//        Optional<Customer> customer = customerRepository.findById(customerId);
//        Customer unwrappedCustomer = CustomerServiceImpl.unwrapCustomer(customer, customerId);
//        car.getCustomer().add(unwrappedCustomer);
//        return carsRepository.save(car);
//    }

    static Car unwrapCar(Optional<Car> entity, Long id) {
        if(entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, Car.class);
    }
}
