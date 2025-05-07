package com.web.flightManagementApplication.service;

import com.web.flightManagementApplication.models.secondary.Employee;

import java.util.List;

public interface EmployeeImp {

    List<Employee> getAllEmployees();

    int updateSalary(String email);
}
