package com.fuzzyrock.cruddemo.dao;

import com.fuzzyrock.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// Set customized resource path
// @RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {}
