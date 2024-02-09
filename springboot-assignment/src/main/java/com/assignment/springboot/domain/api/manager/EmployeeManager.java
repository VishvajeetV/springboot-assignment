package com.assignment.springboot.domain.api.manager;

import com.assignment.springboot.domain.api.mapper.EmployeeMapper;
import com.assignment.springboot.domain.api.resource.EmployeeDTO;
import com.assignment.springboot.domain.api.resource.ResponseDTO;
import com.assignment.springboot.domain.db.models.Employee;
import com.assignment.springboot.domain.exceptions.BusinessException;
import com.assignment.springboot.domain.exceptions.CustomException;
import com.assignment.springboot.domain.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeManager implements BaseManager<EmployeeDTO, Long>{
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public ResponseDTO<EmployeeDTO> findById(Long id) {
        try {
            log.info("inside employee manager find by id: {}", id);
            Optional<Employee> optional = employeeService.findById(id);
            if (optional.isPresent()) {
                EmployeeDTO dto = employeeMapper.mapToResource(optional.get());
                return new ResponseDTO("200", "SUCCESS", true, dto);
            }
        } catch (Exception e) {
            log.error("Exception in employee manager findById[{}], error message: {}, trace: {}", id, e.getMessage(), e.getStackTrace());
        }
        return ResponseDTO.errorResponse("Cannot find address", "200");
    }

    @Override
    public ResponseDTO findAll() {
        try {
            log.info(" inside employee manager find All ");
            Iterable<Employee> employees = employeeService.findAll();
            if (employees != null && employees.iterator().hasNext()) {
                List<EmployeeDTO> dtos = employeeMapper.mapAllToResource(employees);
                return new ResponseDTO("200", "SUCCESS", true, dtos);
            }
        } catch (Exception e) {
            log.error("Exception in employee manager findAll[], error message: {}, trace: {}", e.getMessage(), e.getStackTrace());
        }
        return ResponseDTO.errorResponse("Cannot find address", "200");

    }

    @Override
    public ResponseDTO<EmployeeDTO> create(EmployeeDTO employeeDTO) {
        try {
            log.info("Inside employee manager create[employeeDTO: {}]", employeeDTO);
            EmployeeDTO dto = employeeMapper.mapToResource(employeeService.create(employeeMapper.mapToModel(employeeDTO)));
            return new ResponseDTO("200", "SUCCESS", true, dto);
        }catch (CustomException e) {
            throw e;
        }catch (Exception e) {
            log.error("Exception in employee manager create ,employeeDTO: {}, error message: {}, trace: {}", employeeDTO, e.getMessage(), e.getStackTrace());
            throw new BusinessException("employee is not created");
        }
    }

    public ResponseDTO<List<EmployeeDTO>> create(List<EmployeeDTO> employeeDtos) {
        List<EmployeeDTO> createdEmployees = new ArrayList<>();

        try {
            log.info("Inside employee manager create [employeeDtos: {}]", employeeDtos);
            for (EmployeeDTO employeeDTO : employeeDtos) {
                EmployeeDTO dto = employeeMapper.mapToResource(employeeService.create(employeeMapper.mapToModel(employeeDTO)));
                createdEmployees.add(dto);
            }
            return new ResponseDTO<>("200", "SUCCESS", true, createdEmployees);
        } catch (CustomException e) {
            throw e;
        } catch (Exception e) {
            log.error("Exception in employee manager create, error message: {}, trace: {}", e.getMessage(), e.getStackTrace());
            throw new BusinessException("Unable to create employees");
        }
    }

    @Override
    public ResponseDTO<EmployeeDTO> update(EmployeeDTO employeeDTO) {
        try {
            log.info("Inside employee manager update[ employeeDTO: {}]", employeeDTO);
            EmployeeDTO dto = employeeMapper.mapToResource(employeeService.update(employeeMapper.mapToModel(employeeDTO)));
            return new ResponseDTO("200", "SUCCESS", true, dto);
        } catch (Exception e) {
            log.error("Exception in update[], error message: {}, trace: {}", e.getMessage(), e.getStackTrace());
        }
        return ResponseDTO.errorResponse("Something went Wrong", "200");
    }
}
