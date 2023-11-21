package com.example.employee.service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository empRepository;

    //CREATE EMPLOYEE
    public Employee createEmployee(Employee emp) {
        return empRepository.save(emp);
    }

    //READ EMPLOYEE
    public List<Employee> getEmployees(){
        return empRepository.findAll();
    }

    //DELETE EMPLOYEE
    public void deleteEmployee(Long empID){
        empRepository.deleteById(empID);
    }

    public Employee updateEmployee(Long empId, Employee employeeDetails) {
        Employee emp = empRepository.findById(empId).get();
        emp.setFirstName(employeeDetails.getFirstName());
        emp.setLastName(employeeDetails.getLastName());
        emp.setEmailID(employeeDetails.getEmailID());

        return empRepository.save(emp);

    }

    public Employee getEmployeeById(Long empID){
        return empRepository.findById(empID).get();
    }




}
