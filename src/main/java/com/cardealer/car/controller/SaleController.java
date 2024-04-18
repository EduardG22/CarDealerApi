package com.cardealer.car.controller;

import com.cardealer.car.model.Sale;
import com.cardealer.car.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "sale")
public class SaleController {

    @Autowired
    SaleService saleService;

    @GetMapping("/{id}")
    public ResponseEntity<Sale> getSale(@PathVariable Long id) {
        return new ResponseEntity<>(saleService.getSale(id), HttpStatus.OK);
    }

    @PostMapping("/employee/{employeeId}/car/{carId}/customer/{customerId}")
    public ResponseEntity<Sale> saveSale(@RequestBody Sale sale, @PathVariable Long employeeId, @PathVariable Long carId, @PathVariable Long customerId) {
        return new ResponseEntity<>(saleService.saveSale(sale, employeeId,carId, customerId), HttpStatus.CREATED);
    }
}
