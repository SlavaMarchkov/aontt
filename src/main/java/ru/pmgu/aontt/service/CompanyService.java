package ru.pmgu.aontt.service;

import ru.pmgu.aontt.entity.Company;

import java.util.List;

public interface CompanyService {

    void saveCompany(Company company);

    List<Company> getAllCompanies();

    Company getCompanyById(Long id);

}
