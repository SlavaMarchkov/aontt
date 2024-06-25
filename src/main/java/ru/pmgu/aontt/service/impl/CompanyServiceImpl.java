package ru.pmgu.aontt.service.impl;

import org.springframework.stereotype.Service;
import ru.pmgu.aontt.entity.Company;
import ru.pmgu.aontt.repository.CompanyRepository;
import ru.pmgu.aontt.service.CompanyService;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(final CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public int getSize() {
        return (int) companyRepository.count();
    }

    public Company getById(final Long id) {
        return companyRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public void saveCompany(final Company company) {
        companyRepository.save(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.getAllCompanies();
    }

    @Override
    public Company getCompanyById(final Long id) {
        return companyRepository.getCompanyInfo(id);
    }

}
