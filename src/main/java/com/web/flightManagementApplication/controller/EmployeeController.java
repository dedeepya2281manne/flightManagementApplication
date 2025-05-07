package com.web.flightManagementApplication.controller;

import com.web.flightManagementApplication.models.secondary.Employee;
import com.web.flightManagementApplication.service.EmployeeImp;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/v2/app")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger("reqRes");

    @Autowired
    private EmployeeImp employeeImp;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeImp.getAllEmployees();
    }

    @GetMapping("/update")
    public String updateSalaryByEmail(@RequestParam("email") String email){
        if(employeeImp.updateSalary(email)>=0) return "UPDATED";
        return "NO RECORDS TO UPDATE";
    }

}
