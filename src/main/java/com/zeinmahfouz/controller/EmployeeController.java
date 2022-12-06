package com.zeinmahfouz.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zeinmahfouz.business.dto.EmployeeDto;
import com.zeinmahfouz.business.services.impl.EmployeeServiceImpl;
import com.zeinmahfouz.data.entity.EmployeeEntity;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody final EmployeeDto employeeDto){
        EmployeeEntity employee= employeeService.addEmployee(EmployeeEntity.from(employeeDto));
        return new ResponseEntity<>(EmployeeDto.from(employee), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getEmployee(){
        List<EmployeeEntity> employeeEntities =employeeService.getEmployee();
        List<EmployeeDto> employeeDto= employeeEntities.stream().map(EmployeeDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(employeeDto,HttpStatus.OK);
    }
    @GetMapping(value="{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable final Long id){
        EmployeeEntity employeeEntity=employeeService.getEmployee(id);
        return new ResponseEntity<>(EmployeeDto.from(employeeEntity),HttpStatus.OK);
    }

    @DeleteMapping(value="{id}")
    public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable final Long id){
        EmployeeEntity employeeEntity=employeeService.deleteEmployee(id);
        return new ResponseEntity<>(EmployeeDto.from(employeeEntity),HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<EmployeeDto> editEmployee(@PathVariable final Long id,
                                                    @RequestBody final EmployeeDto employeeDto){
        EmployeeEntity editedEmployee = employeeService.editEmployee(id,EmployeeEntity.from(employeeDto));
        return new ResponseEntity<>(EmployeeDto.from(editedEmployee), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<EmployeeDto> SalaryCalu(@RequestBody final EmployeeDto employeeDto){
        EmployeeEntity employeeEntity= employeeService.SalaryCalu(EmployeeEntity.from(employeeDto));
        return new ResponseEntity<>(EmployeeDto.from(employeeEntity),HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<EmployeeDto> salary(@RequestBody final EmployeeDto employeeDto){
        EmployeeEntity employeeEntity= employeeService.salary(EmployeeEntity.from(employeeDto));
        return new ResponseEntity<>(EmployeeDto.from(employeeEntity),HttpStatus.OK);

    }
}
