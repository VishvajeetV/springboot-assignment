package com.assignment.springboot.domain.db.dao;

import com.assignment.springboot.domain.db.models.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee, Long> {
}
