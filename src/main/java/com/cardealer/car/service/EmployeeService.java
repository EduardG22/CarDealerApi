package com.cardealer.car.service;

import com.cardealer.car.entity.Employee;

import java.util.List;


public interface EmployeeService {

    Employee getEmployee(Long id);

    Employee saveEmployees(Employee employee);

    Employee updateEmployee(Long id, Employee updatedEmployee);

    void deleteEmployee(Long id);

    List<Employee> getAllEmployees();
}
