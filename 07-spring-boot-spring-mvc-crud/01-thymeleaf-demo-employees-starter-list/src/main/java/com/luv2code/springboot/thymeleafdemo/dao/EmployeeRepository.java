package com.luv2code.springboot.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!

    // Spring Data JPA will parse the method name,
    // and it will look for a specific format and pattern,
    // then create appropriate query behind the scene.
    public List<Employee> findAllByOrderByLastNameAsc();
	
}
