package com.assignment.springboot.domain.service.Impl;

import com.assignment.springboot.domain.db.dao.EmployeeDao;
import com.assignment.springboot.domain.db.models.Employee;
import com.assignment.springboot.domain.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeDao.findById(id);
    }

    @Override
    public Iterable<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee create(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeDao.save(employee);
    }
}
