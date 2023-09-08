package com.fuzzyrock.cruddemo.dao;

import com.fuzzyrock.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
