package com.assignment.springboot.domain.api.mapper;

import com.assignment.springboot.domain.api.resource.DepartmentDTO;
import com.assignment.springboot.domain.db.models.Department;
import com.assignment.springboot.domain.db.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentMapper implements BaseMapper<Department, DepartmentDTO>{
    @Override
    public Department mapToModel(DepartmentDTO departmentDTO) {
        if (departmentDTO != null) {
            Department department = new Department();
            department.setId(departmentDTO.getId());
            department.setName(departmentDTO.getName());
            return department;
        }
        return null;
    }

    @Override
    public DepartmentDTO mapToResource(Department department) {
        if (department != null) {
            DepartmentDTO departmentDTO = new DepartmentDTO();
            departmentDTO.setId(department.getId());
            departmentDTO.setName(department.getName());
            return departmentDTO;
        }
        return null;
    }
}
