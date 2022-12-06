package com.zeinmahfouz.business.services;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zeinmahfouz.business.services.impl.EmployeeServiceImpl;
import com.zeinmahfouz.data.entity.EmployeeEntity;
import com.zeinmahfouz.data.entity.companyEntity;
import com.zeinmahfouz.data.repository.CompanyRepository;
import com.zeinmahfouz.exception.EmployeeAllreadyAssignedException;
import com.zeinmahfouz.exception.ResourceNotFoundException;


@Service
public class CompanyServices {
    private final CompanyRepository companyRepository;
    private final EmployeeServiceImpl employeeService;

    @Autowired
    public CompanyServices(CompanyRepository companyRepository, EmployeeServiceImpl employeeService) {
        this.companyRepository = companyRepository;
        this.employeeService = employeeService;
    }



    public static companyEntity addCompany(companyEntity companyEntity){

        try {
			return CompanyRepository.save(companyEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public List<companyEntity> getCompany(){
        return StreamSupport
                .stream(companyRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    public companyEntity getCompany(Long id){
        return companyRepository.findAllById(id).orElseThrow(() ->
                new ResourceNotFoundException(id));
    }

    public companyEntity deleteCompany(Long id){
        companyEntity companyEntity=getCompany(id);
        companyRepository.delete(companyEntity);
        return companyEntity;
    }


    @Transactional
    public companyEntity editCompany(Long id, companyEntity companyEntity){
        companyEntity companyToEdit =getCompany(id);
        companyToEdit.setCompanyName(companyEntity.getCompanyName());
        return companyToEdit;
    }

    @Transactional
    public companyEntity addEmployeetoCompany(Long comid,Long empid){
        companyEntity company=getCompany(comid);
        EmployeeEntity employee=employeeService.getEmployee(empid);
        if(Objects.nonNull(employee.getCompany())){
            throw new EmployeeAllreadyAssignedException(empid,((companyEntity) employee
                    .getCompany()).getComid());
        }
        company.addemployeeEntity(employee);
        employee.setCompany(company);
        return company;
    }

    @Transactional
    public companyEntity removeEmployeeFromCompany(Long comid,Long empid){
        companyEntity company= getCompany(comid);
        EmployeeEntity employee= employeeService.getEmployee(empid);
        company.removemployeeEntity(employee);
        return company;
    }


}