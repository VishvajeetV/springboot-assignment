package com.assignment.springboot.domain.db.dao;

import com.assignment.springboot.domain.db.models.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentDao extends CrudRepository<Department, Long> {
}
