package com.example.restapi.service;

import com.example.restapi.model.Employee;

import java.util.List;

public interface EmployeeService {
   //select all db
    List<Employee> getEmployees();
    //tao 1 ban ghi
    Employee saveEmployee(Employee employee);
    //doc 1 ban ghi
    Employee getSingleEmployee(Long id);
    //xoa record
    void deleteEmployee(Long id);
    //cap nhat
    Employee updateEmployee(Employee employee);
}
