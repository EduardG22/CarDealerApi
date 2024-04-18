package com.cardealer.car.service;

import com.cardealer.car.exceptions.EntityNotFoundException;
import com.cardealer.car.model.Cars;
import com.cardealer.car.repository.CarsRepository;
import com.cardealer.car.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarsServiceImpl implements CarsService {

    @Autowired
    CarsRepository carsRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Cars getCars(Long id) {
        Optional<Cars> cars = carsRepository.findById(id);
        return unwrapCar(cars,id);
    }


    @Override
    public Cars saveCar(Cars cars, Long carId) {
        return carsRepository.save(cars);
    }

    @Override
    public void deleteCar(Long id) {
      carsRepository.deleteById(id);
    }

    @Override
    public List<Cars> getAllCars() {
        return (List<Cars>) carsRepository.findAll();
    }

//    @Override
//    public Cars addCarToCustomer(Long customerId, Long carId) {
//        Cars car = getCars(carId);
//        Optional<Customer> customer = customerRepository.findById(customerId);
//        Customer unwrappedCustomer = CustomerServiceImpl.unwrapCustomer(customer, customerId);
//        car.getCustomer().add(unwrappedCustomer);
//        return carsRepository.save(car);
//    }

    static Cars unwrapCar(Optional<Cars> entity, Long id) {
        if(entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, Cars.class);
    }
}
