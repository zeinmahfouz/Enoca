package com.zeinmahfouz.business.dto;

import com.zeinmahfouz.data.entity.companyEntity;

import lombok.Data;

@Data
public class PlainCompanyDto {
    public static PlainCompanyDto from(Object object){
        PlainCompanyDto plainCompanyDto= new PlainCompanyDto();
        plainCompanyDto.setId(((companyEntity) object).getComid());
        plainCompanyDto.setName(((companyEntity) object).getCompanyName());
        return plainCompanyDto;
    }


	private void setName(Object companyName) {
		// TODO Auto-generated method stub

	}

	private void setId(Object comid) {
		// TODO Auto-generated method stub

	}




}
