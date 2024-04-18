package com.cardealer.car.service;

import com.cardealer.car.model.Cars;
import com.cardealer.car.model.Customer;
import com.cardealer.car.model.Employee;
import com.cardealer.car.model.Sale;
import com.cardealer.car.repository.CarsRepository;
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
    CarsRepository carsRepository;
    CustomerRepository customerRepository;

    @Override
    public Sale getSale(Long id) {
        return saleRepository.findById(id).get();
    }

    @Override
    public Sale saveSale(Sale sale, Long employeeId, Long carId, Long customerId) {

        Employee employee = employeeRepository.findById(employeeId).get();
        Cars car = carsRepository.findById(carId).get();
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
