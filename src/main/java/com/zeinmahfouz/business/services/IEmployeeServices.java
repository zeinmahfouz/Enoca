package com.zeinmahfouz.business.services;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.zeinmahfouz.business.dto.EmployeeDto;
import com.zeinmahfouz.data.entity.EmployeeEntity;

public interface IEmployeeServices {

    //model
    public EmployeeDto EntityTODto(EmployeeEntity employeeEntity);
    public EmployeeEntity DtotoEntity(EmployeeDto employeeDto);

    //CRUD
    //Save
    public EmployeeDto createEmployee(EmployeeDto employeeDto);

    //list
    public List<EmployeeDto> getAllEmployee();

    //find
    public ResponseEntity<EmployeeDto> getEmployeeById(Long id);

    //update
    public ResponseEntity<EmployeeDto> updateEmployee(Long id,EmployeeDto employeeDto);

    //delete
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(Long id);

}

