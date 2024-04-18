package com.cardealer.car.service;

import com.cardealer.car.model.Sale;

import java.util.List;


public interface SaleService {

    Sale getSale(Long id);

    Sale saveSale(Sale sale, Long employeeId, Long carId, Long customerId);

    void deleteSale(Long id);

    List<Sale> getAllSales();
}
