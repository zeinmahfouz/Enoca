package com.zeinmahfouz.ui.rest;


import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.zeinmahfouz.business.dto.EmployeeDto;

public interface IEmployeeRest {
    //save
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    //list
    List<EmployeeDto> getAllEmployees();

    //find
    ResponseEntity<EmployeeDto> getEmployeeById(Long id);

    //update
    ResponseEntity<EmployeeDto> updateEmployee(Long id,EmployeeDto employeeDto);

    //delete
    ResponseEntity<Map<String,Boolean>> deleteEmployee(Long id);
}
