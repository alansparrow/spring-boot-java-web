package com.fuzzyrock.cruddemo.dao;

import com.fuzzyrock.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
