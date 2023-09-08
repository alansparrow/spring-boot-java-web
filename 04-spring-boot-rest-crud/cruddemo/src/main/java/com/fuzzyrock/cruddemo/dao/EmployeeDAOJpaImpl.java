package com.fuzzyrock.cruddemo.dao;

import com.fuzzyrock.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);

        List<Employee> employees = query.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    // Don't use @Transactional here at DAO layer.
    // It will be handled at Service layer.
    @Override
    public Employee save(Employee employee) {
        // If id == 0, then insert, else update
        Employee savedEmployee = entityManager.merge(employee);

        return savedEmployee;
    }

    // Don't use @Transactional here at DAO layer.
    // It will be handled at Service layer.
    @Override
    public void deleteById(int id) {
        Employee employee = entityManager.find(Employee.class, id);

        entityManager.remove(employee);
    }
}
