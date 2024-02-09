package com.assignment.springboot.domain.service.Impl;

import com.assignment.springboot.domain.db.dao.DepartmentDao;
import com.assignment.springboot.domain.db.models.Department;
import com.assignment.springboot.domain.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;
    @Override
    public Optional<Department> findById(Long id) {
        return departmentDao.findById(id);
    }

    @Override
    public Iterable<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public Department create(Department department) {
        return departmentDao.save(department);
    }

    @Override
    public Department update(Department department) {
        return departmentDao.save(department);
    }
}
