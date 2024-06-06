package com.example.restapi.service;

import com.example.restapi.model.Employee;
import com.example.restapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository eRepository;

    @Override
    public List<Employee> getEmployees() {
        return eRepository.findAll();
        //liet ke tat ca cac employee
    }
    //
    @Override
    public Employee saveEmployee(Employee employee) {
        return eRepository.save(employee);
        //them mot employee vao db
    }

    @Override
    public Employee getSingleEmployee(Long id) {
        //tim kiem theo id
         Optional<Employee> employee  =  eRepository.findById(id);
         if (employee.isPresent()){
             return employee.get();
         }
         throw new RuntimeException("Employee is not found for the id "+ id);
    }

    @Override
    public void deleteEmployee(Long id) {
        eRepository.deleteById(id);
        //xoa employee ra csdl
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return eRepository.save(employee);
        //cap nhat thong tin employee vao db
    }
}


