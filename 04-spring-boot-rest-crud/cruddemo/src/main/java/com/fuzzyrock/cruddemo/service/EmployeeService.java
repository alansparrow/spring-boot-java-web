package com.fuzzyrock.cruddemo.service;

import com.fuzzyrock.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
