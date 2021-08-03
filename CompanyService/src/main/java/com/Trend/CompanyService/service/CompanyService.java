package com.Trend.CompanyService.service;

import com.Trend.CompanyService.entity.Company;
import com.Trend.CompanyService.repository.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final KafkaProducerService kafkaService;

    public CompanyService(CompanyRepository companyRepository, KafkaProducerService kafkaService) {
        this.companyRepository = companyRepository;
        this.kafkaService = kafkaService;
    }

    public Company findById(Long id) {
        return companyRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Entity with id: %s does not exists.", id)
        ));
    }

    public Company findByEmail(String email)
    {
        return this.companyRepository.findByCompanyEMail(email);
    }

    public Company createCompany(Company company) {
        if (companyRepository.existsByCompanyEMail(company.getCompanyEMail()))
            throw new RuntimeException("Email has already taken.");
        return companyRepository.save(company);
    }

    public void deleteById(Long id) {
        companyRepository.deleteById(id);
        kafkaService.sendMessage(id.toString(),"deleteCompany");
    }

    public Company updateCompany(Company company) {
        Long companyId = company.getId();
        this.findById(companyId);
        return companyRepository.save(company);
    }

    public Iterable<Company> findAll() {
        return companyRepository.findAll();
    }
}
