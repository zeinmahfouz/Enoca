package com.zeinmahfouz.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.zeinmahfouz.business.dto.EmployeeDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//entity
@Entity
@Table(name="employees")
public class EmployeeEntity{
    @Id
    @SequenceGenerator(name="seq_employee",allocationSize = 1)
    @GeneratedValue(generator = "seq_employee",strategy = GenerationType.SEQUENCE)
    private Long empid;

   @ManyToOne
    private companyEntity company;

    @Column(name = "employee_name")
    public String employeeName;

    @Column(name = "employee_email")
    public String employeeEmail;

    @Column(name = "employee_age")
    public int employeeage;

    @Column(name = "employee_salary")
    public int employeesalary;

    @Column(name = "employee_workingyear")
    public int employeeworkingyear;

    public static EmployeeEntity from(EmployeeDto employeeDto){
        EmployeeEntity employee= new EmployeeEntity();
        employee.setEmployeeName(employeeDto.getEmployeeName());
        employee.setEmployeeEmail(employeeDto.getEmployeeEmail());
        employee.setEmployeeage(employeeDto.getEmployeeage());
        employee.setEmployeesalary(employeeDto.getEmployeesalary());
        employee.setEmployeeworkingyear(employeeDto.getEmployeeworkingyear());
        return employee;
    }


	private void setEmployeeEmail(Object employeeEmail) {
		// TODO Auto-generated method stub

	}

	public EmployeeEntity(){
        this.employeeage=employeeage;
        this.employeeworkingyear=employeeworkingyear;
        this.employeesalary=employeesalary;
    }

    public void salary(){
        if((2020-this.employeeworkingyear)>365){
            this.employeesalary=this.employeesalary*10/100;
        }
    }
    public void Bonus(){
        if(this.employeeage>=20 && this.employeeage<=25){
            this.employeesalary = this.employeesalary*10/100;
        }else if(this.employeeage>=26 && this.employeeage<=30) {
            this.employeesalary = this.employeesalary*8/100;
        }else if(this.employeeage>=31 && this.employeeage<=36) {
            this.employeesalary = this.employeesalary*5/100;
        }else {
            this.employeesalary=this.employeesalary*3/100;
        }
    }

    @Override
	public String toString(){
        return "Employee{"+
                "employeeId=" + empid+
                ",employeeName=" + employeeName+'\''+
                ",employeeAge=" + employeeage+
                ",employeeName=" + employeesalary+
                ",employeeworkingyear=" + employeeworkingyear+
                ",company=" + company+
                '}';

    }

	public void setCompany(companyEntity company) {
	}

	public Object getEmployeeName() {
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
	public Object getEmployeeworkingyear() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setEmployeeName(Object employeeName) {
		// TODO Auto-generated method stub

	}
	public void setEmployeeage(Object employeeage) {
		// TODO Auto-generated method stub

	}
	public void setEmployeesalary(Object employeesalary) {
		// TODO Auto-generated method stub

	}

	public Object getCompany() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setEmployeeworkingyear(Object employeeworkingyear) {
		// TODO Auto-generated method stub

	}



	     }
