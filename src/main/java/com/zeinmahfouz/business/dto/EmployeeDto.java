package com.zeinmahfouz.business.dto;


import java.util.Objects;

import com.zeinmahfouz.data.entity.EmployeeEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

@ToString
public class EmployeeDto {

    public Long employeeId;
    public String employeeName;
    public String employeeEmail;
    public int employeeage;
    public int employeesalary;
    public int employeeworkingyear;

    public static EmployeeDto from(EmployeeEntity employeeEntity){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeId(employeeDto.getEmployeeId());
        employeeDto.setEmployeeName(employeeDto.getEmployeeName());
        employeeDto.setEmployeeEmail(employeeDto.getEmployeeEmail());
        employeeDto.setEmployeeage(employeeDto.getEmployeeage());
        employeeDto.setEmployeesalary(employeeDto.getEmployeesalary());
        employeeDto.setEmployeeworkingyear(employeeDto.getEmployeeworkingyear());
        if(Objects.nonNull(employeeEntity.getCompany())){
            employeeDto.setPlainCompanyDto(from((EmployeeEntity) employeeEntity.getCompany()));
        }
        return employeeDto;
    }



	private EmployeeDto() {
		// TODO Auto-generated method stub

	}
	private void setEmployeesalary(Object employeesalary) {
		// TODO Auto-generated method stub

	}
	private Object getEmployeeId() {
		// TODO Auto-generated method stub
		return null;
	}
	private void setPlainCompanyDto(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub

	}
	//private companyEntity companyEntity;




	public void getEmployeeworkingyear() {
		// TODO Auto-generated method stub
	}

	private void setEmployeeage(Object employeeage2) {
		// TODO Auto-generated method stub

	}

	private void setEmployeeId(Object employeeId2) {
		// TODO Auto-generated method stub

	}

	private void setEmployeeName(Object employeeName2) {
		// TODO Auto-generated method stub

	}

	private void setEmployeeEmail(Object employeeEmail2) {
		// TODO Auto-generated method stub

	}
	public Object getEmployeeName() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getEmployeeEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getEmployeeage() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getEmployeesalary() {
		// TODO Auto-generated method stub
		return null;
	}

}