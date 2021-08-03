package com.Trend.CompanyService.entity;

import javax.persistence.*;
@Entity
@Table(name = "Companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String companyEMail;

    public Company()
    {

    }
    public Company(Long id, String companyName, String companyEMail) {
        this.id = id;
        this.companyName = companyName;
        this.companyEMail = companyEMail;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyEMail() {
        return companyEMail;
    }

    public void setCompanyEMail(String companyEMail) {
        this.companyEMail = companyEMail;
    }
}
