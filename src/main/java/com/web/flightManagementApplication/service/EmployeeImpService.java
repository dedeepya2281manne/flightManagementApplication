package com.web.flightManagementApplication.service;

import com.web.flightManagementApplication.models.secondary.Employee;
import com.web.flightManagementApplication.repository.secondary.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeImpService implements EmployeeImp{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll(Sort.by(Sort.Direction.DESC,"salary")); //by default ascending order
    }

    @Override
    public int updateSalary(String email) {
        return employeeRepository.updateSalaryByEmail(email);
    }
}
