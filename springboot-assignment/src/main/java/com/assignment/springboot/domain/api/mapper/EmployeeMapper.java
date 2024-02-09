package com.assignment.springboot.domain.api.mapper;

import com.assignment.springboot.domain.api.resource.EmployeeDTO;
import com.assignment.springboot.domain.db.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper implements BaseMapper<Employee, EmployeeDTO> {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public Employee mapToModel(EmployeeDTO employeeDTO) {
        if (employeeDTO != null) {
            Employee employee = new Employee();
            employee.setId(employeeDTO.getId());
            employee.setName(employeeDTO.getName());
            employee.setDepartment(departmentMapper.mapToModel(employeeDTO.getDepartment()));
            return employee;
        }
        return null;
    }

    @Override
    public EmployeeDTO mapToResource(Employee employee) {
        if (employee != null) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(employee.getId());
            employeeDTO.setName(employee.getName());
            employeeDTO.setDepartment(departmentMapper.mapToResource(employee.getDepartment()));
            return employeeDTO;
        }
        return null;
    }
}
