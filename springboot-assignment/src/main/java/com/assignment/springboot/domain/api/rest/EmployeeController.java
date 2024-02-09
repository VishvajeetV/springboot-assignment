package com.assignment.springboot.domain.api.rest;

import com.assignment.springboot.domain.api.manager.EmployeeManager;
import com.assignment.springboot.domain.api.resource.EmployeeDTO;
import com.assignment.springboot.domain.api.resource.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/employee")
    public class EmployeeController {
        @Autowired
        private EmployeeManager employeeManager;

        @PostMapping(value = "")
        public ResponseDTO create(@RequestBody EmployeeDTO employee) {
            return employeeManager.create(employee);
        }

        @PostMapping("/create")
        public ResponseDTO<List<EmployeeDTO>> createEmployees(@RequestBody List<EmployeeDTO> employees) {
            return employeeManager.create(employees);
        }

        @GetMapping(value = "/{id}")
        public ResponseDTO findById(@PathVariable(name = "id") Long id) {
            return employeeManager.findById(id);
        }

        @GetMapping(value = "")
        public ResponseDTO findAll() {
            return employeeManager.findAll();
        }

}
