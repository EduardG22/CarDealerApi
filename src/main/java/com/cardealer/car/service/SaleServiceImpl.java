package com.cardealer.car.service;

import com.cardealer.car.entity.Car;
import com.cardealer.car.entity.Customer;
import com.cardealer.car.entity.Employee;
import com.cardealer.car.entity.Sale;
import com.cardealer.car.repository.CarRepository;
import com.cardealer.car.repository.CustomerRepository;
import com.cardealer.car.repository.EmployeeRepository;
import com.cardealer.car.repository.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SaleServiceImpl implements SaleService {


    SaleRepository saleRepository;
    EmployeeRepository employeeRepository;
    CarRepository carsRepository;
    CustomerRepository customerRepository;

    @Override
    public Sale getSale(Long id) {
        return saleRepository.findById(id).get();
    }

    @Override
    public Sale saveSale(Sale sale, Long employeeId, Long carId, Long customerId) {

        Employee employee = employeeRepository.findById(employeeId).get();
        Car car = carsRepository.findById(carId).get();
        Customer customer = customerRepository.findById(customerId).get();

        sale.setEmployee(employee);
        sale.setCar(car);
        sale.setCustomer(customer);

        return saleRepository.save(sale);
    }

    @Override
    public void deleteSale(Long id) {
        saleRepository.deleteById(id);
    }

    @Override
    public List<Sale> getAllSales() {
        return (List<Sale>) saleRepository.findAll();
    }
}
