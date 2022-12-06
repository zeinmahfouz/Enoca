package com.zeinmahfouz.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zeinmahfouz.data.entity.companyEntity;

public interface CompanyRepository extends JpaRepository<companyEntity,Long> {

	Object findAllById(Long id);
}
