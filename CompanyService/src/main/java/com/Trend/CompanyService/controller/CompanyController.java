package com.Trend.CompanyService.controller;

import com.Trend.CompanyService.entity.Company;
import com.Trend.CompanyService.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("company/")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(@Autowired CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public Iterable<Company> findAllCompanies() {
        return companyService.findAll();
    }

    @GetMapping("{id}")
    public Company findById(@PathVariable Long id) {
        System.out.printf("CompanyController :: findById :: CompanyId = %s%n\n", id);
        return companyService.findById(id);
    }

    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        System.out.printf("CompanyController :: createCompany :: %s\n", company);
        return companyService.createCompany(company);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        System.out.printf("CompanyController :: deleteById :: CompanyId = %s%n", id);
        companyService.deleteById(id);
    }

    @PutMapping
    public Company updateCompany(@RequestBody Company company) {
        System.out.printf("CompanyController :: updateCompany :: Company = %s%n", company);
        return companyService.updateCompany(company);
    }
}
