package com.assignment.springboot.domain.api.rest;

import com.assignment.springboot.domain.api.manager.DepartmentManager;
import com.assignment.springboot.domain.api.resource.DepartmentDTO;
import com.assignment.springboot.domain.api.resource.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentManager departmentManager;
    @PostMapping(value = "")
    public ResponseDTO create(@RequestBody DepartmentDTO department) {
        return departmentManager.create(department);
    }
    @PostMapping("/create")
    public ResponseDTO<List<DepartmentDTO>> createDepartments(@RequestBody List<DepartmentDTO> departments) {
        return departmentManager.create(departments);
    }

    @GetMapping(value = "/{id}")
    public ResponseDTO findById(@PathVariable(name = "id") Long id) {
        return departmentManager.findById(id);
    }

    @GetMapping(value = "")
    public ResponseDTO findAll() {
        return departmentManager.findAll();
    }
}
