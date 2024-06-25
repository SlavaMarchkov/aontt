package ru.pmgu.aontt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.pmgu.aontt.entity.Company;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("SELECT c FROM Company c JOIN FETCH c.branches")
    List<Company> getAllCompanies();

    @Query("SELECT c FROM Company c JOIN FETCH c.branches WHERE c.id = :id")
    Company getCompanyInfo(Long id);

}
