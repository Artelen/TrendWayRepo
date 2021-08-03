package com.Trend.CompanyService.repository;

import com.Trend.CompanyService.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
        boolean existsByCompanyEMail(String companyEMail);

        Company findByCompanyEMail(String companyEMail);
}
