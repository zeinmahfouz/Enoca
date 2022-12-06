package com.zeinmahfouz.business.services.impl;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeinmahfouz.data.entity.EmployeeEntity;
import com.zeinmahfouz.data.repository.EmployeeRepository;
import com.zeinmahfouz.exception.ResourceNotFoundException;

import lombok.extern.log4j.Log4j2;


@Service
@Log4j2
public class EmployeeServiceImpl {

    public final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository= employeeRepository;
    }

    public EmployeeEntity addEmployee(EmployeeEntity employeeEntity){
        return employeeRepository.save(employeeEntity);
    }

    public List<EmployeeEntity> getEmployee(){
        return StreamSupport.stream(employeeRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }
    public EmployeeEntity getEmployee(Long id){
        return employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(id));
    }
    public EmployeeEntity deleteEmployee(Long id){
        EmployeeEntity employeeEntity=getEmployee(id);
        employeeRepository.delete(employeeEntity);
        return employeeEntity;
    }

    @Transactional
    public EmployeeEntity editEmployee(Long id , EmployeeEntity employeeEntity){
        EmployeeEntity employeeToEdit=getEmployee(id);
        employeeToEdit.setEmployeeName(employeeEntity.getEmployeeName());
        employeeToEdit.setEmployeeage(employeeEntity.getEmployeeage());
        employeeToEdit.setEmployeesalary(employeeEntity.getEmployeesalary());
        employeeToEdit.setEmployeeworkingyear(employeeEntity.getEmployeeworkingyear());
        return employeeToEdit;
    }

    public EmployeeEntity SalaryCalu(EmployeeEntity employeeEntity){
        employeeEntity.setEmployeeage(employeeEntity.getEmployeeage());
        employeeEntity.setEmployeesalary(employeeEntity.getEmployeesalary());
        employeeEntity.setEmployeeworkingyear(employeeEntity.getEmployeeworkingyear());
        employeeEntity.Bonus();
        return employeeEntity;
    }
    public EmployeeEntity salary(EmployeeEntity employeeEntity){
        employeeEntity.setEmployeesalary(employeeEntity.getEmployeesalary());
        employeeEntity.setEmployeeworkingyear(employeeEntity.getEmployeeworkingyear());
        return employeeEntity;
    }

}
