package com.assignment.springboot.domain.api.manager;

import com.assignment.springboot.domain.api.mapper.DepartmentMapper;
import com.assignment.springboot.domain.api.mapper.EmployeeMapper;
import com.assignment.springboot.domain.api.resource.DepartmentDTO;
import com.assignment.springboot.domain.api.resource.EmployeeDTO;
import com.assignment.springboot.domain.api.resource.ResponseDTO;
import com.assignment.springboot.domain.db.models.Department;
import com.assignment.springboot.domain.exceptions.BusinessException;
import com.assignment.springboot.domain.exceptions.CustomException;
import com.assignment.springboot.domain.service.DepartmentService;
import com.assignment.springboot.domain.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DepartmentManager implements BaseManager<DepartmentDTO, Long>{
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public ResponseDTO<DepartmentDTO> findById(Long id) {
          try {
            log.info("inside department manager find by id: {}", id);
            Optional<Department> optional = departmentService.findById(id);
            if (optional.isPresent()) {
                DepartmentDTO dto = departmentMapper.mapToResource(optional.get());
                return new ResponseDTO("200", "SUCCESS", true, dto);
            }
        } catch (Exception e) {
            log.error("Exception in department manager findById[{}], error message: {}, trace: {}", id, e.getMessage(), e.getStackTrace());
        }
        return ResponseDTO.errorResponse("Cannot find departments", "200");
    }

    @Override
    public ResponseDTO findAll() {
        try {
            log.info(" inside department manager find All ");
            Iterable<Department> departments = departmentService.findAll();
            if (departments != null && departments.iterator().hasNext()) {
                List<DepartmentDTO> dtos = departmentMapper.mapAllToResource(departments);
                return new ResponseDTO("200", "SUCCESS", true, dtos);
            }
        } catch (Exception e) {
            log.error("Exception in department manager findAll[], error message: {}, trace: {}", e.getMessage(), e.getStackTrace());
        }
        return ResponseDTO.errorResponse("Cannot find departments", "200");

    }

    @Override
    public ResponseDTO<DepartmentDTO> create(DepartmentDTO departmentDTO) {
        try {
            log.info("Inside department manager create[departmentDTO: {}]", departmentDTO);
            DepartmentDTO dto = departmentMapper.mapToResource(departmentService.create(departmentMapper.mapToModel(departmentDTO)));
            return new ResponseDTO("200", "SUCCESS", true, dto);
        }catch (CustomException e) {
            throw e;
        }catch (Exception e) {
            log.error("Exception in department manager create ,departmentDTO: {}, error message: {}, trace: {}", departmentDTO, e.getMessage(), e.getStackTrace());
            throw new BusinessException("department is not added");
        }
    }


    public ResponseDTO<List<DepartmentDTO>> create(List<DepartmentDTO> departmentDtos) {
        List<DepartmentDTO> createdDepartments = new ArrayList<>();

        try {
            log.info("Inside department manager create [departmentDtos: {}]", departmentDtos);
            for (DepartmentDTO departmentDto : departmentDtos) {
                DepartmentDTO dto = departmentMapper.mapToResource(departmentService.create(departmentMapper.mapToModel(departmentDto)));
                createdDepartments.add(dto);
            }
            return new ResponseDTO<>("200", "SUCCESS", true, createdDepartments);
        } catch (CustomException e) {
            throw e;
        } catch (Exception e) {
            log.error("Exception in department manager create, error message: {}, trace: {}", e.getMessage(), e.getStackTrace());
            throw new BusinessException("Unable to create departments");
        }
    }







    @Override
    public ResponseDTO<DepartmentDTO> update(DepartmentDTO departmentDTO) {
        try {
            log.info("Inside department manager update[ departmentDTO: {}]", departmentDTO);
            DepartmentDTO dto = departmentMapper.mapToResource(departmentService.update(departmentMapper.mapToModel(departmentDTO)));
            return new ResponseDTO("200", "SUCCESS", true, dto);
        } catch (Exception e) {
            log.error("Exception in update[], error message: {}, trace: {}", e.getMessage(), e.getStackTrace());
        }
        return ResponseDTO.errorResponse("Something went Wrong", "200");
    }
}
