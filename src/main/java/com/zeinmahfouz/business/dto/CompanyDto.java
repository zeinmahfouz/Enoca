package com.zeinmahfouz.business.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.zeinmahfouz.data.entity.companyEntity;

import lombok.Data;

@Data
public class CompanyDto {
    public static CompanyDto from(companyEntity companyeentity){
        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(companyeentity.getComid());
        companyDto.setCompanyname(companyeentity.getCompanyName());
        companyDto.setEmployeeDto(companyeentity.getEmployeeEntities().stream().map(null).collect(Collectors.toList()));
        return companyDto;
    }

	private void setEmployeeDto(List<Object> collect) {
		// TODO Auto-generated method stub

	}

	private void setCompanyname(Object companyName2) {
		// TODO Auto-generated method stub

	}

	private void setId(Object comid) {
		// TODO Auto-generated method stub

	}

	public Object getCompanyName() {
		// TODO Auto-generated method stub
		return null;
	}

}
