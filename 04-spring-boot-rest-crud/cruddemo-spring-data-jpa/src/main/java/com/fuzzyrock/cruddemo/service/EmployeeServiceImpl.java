package com.fuzzyrock.cruddemo.service;

import com.fuzzyrock.cruddemo.dao.EmployeeRepository;
import com.fuzzyrock.cruddemo.entity.Employee;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
  private EmployeeRepository employeeRepository;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee findById(int id) {
    Optional<Employee> result = employeeRepository.findById(id);

    return result.orElse(null);
  }

  @Override
  public Employee save(Employee employee) {
    return employeeRepository.save(employee);
  }

  @Override
  public void deleteById(int id) {
    employeeRepository.deleteById(id);
  }
}
