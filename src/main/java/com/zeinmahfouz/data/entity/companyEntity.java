package com.zeinmahfouz.data.entity;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zeinmahfouz.business.dto.CompanyDto;
import com.zeinmahfouz.business.dto.EmployeeDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "company")
public class companyEntity{
   // @Id
    @Id
    @GeneratedValue
    private Long comid;

    @Column(name = "company_name")
    private String companyName;


    @Column(name = "employee_entities")
    @JsonIgnore
    @OneToMany(targetEntity = EmployeeEntity.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "cp_fk",referencedColumnName = "comid")
    private List<EmployeeEntity> employeeEntities= new ArrayList<>();

    public  void addemployeeEntity(EmployeeEntity employeeEntity){
         employeeEntities.add(employeeEntity);
     }

    public  void removemployeeEntity(EmployeeEntity employeeEntity){
        employeeEntities.remove(employeeEntity);
    }

    public static companyEntity from(CompanyDto companyDto){
        companyEntity company= new companyEntity();
        company.setCompanyName(companyDto.getCompanyName());
        return company;
    }




	public void setCompanyName(Object companyName2) {
		// TODO Auto-generated method stub

	}

	public Object getCompanyName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getComid() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<EmployeeDto> getEmployeeEntities() {
		// TODO Auto-generated method stub
		return null;
	}





}

