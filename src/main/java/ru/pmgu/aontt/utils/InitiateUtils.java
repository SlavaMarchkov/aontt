package ru.pmgu.aontt.utils;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import ru.pmgu.aontt.entity.Branch;
import ru.pmgu.aontt.entity.Company;
import ru.pmgu.aontt.entity.Director;
import ru.pmgu.aontt.service.impl.BranchServiceImpl;
import ru.pmgu.aontt.service.impl.CompanyServiceImpl;
import ru.pmgu.aontt.service.impl.DirectorServiceImpl;

import java.util.Locale;
import java.util.Random;

@Service
public class InitiateUtils implements CommandLineRunner {

    private final Random random = new Random();
    private final Faker faker = new Faker(new Locale("ru-RU"));
    private final DirectorServiceImpl directorService;
    private final BranchServiceImpl branchService;
    private final CompanyServiceImpl companyService;

    public InitiateUtils(final DirectorServiceImpl directorService,
                         final BranchServiceImpl branchService,
                         final CompanyServiceImpl companyService
    ) {
        this.directorService = directorService;
        this.branchService = branchService;
        this.companyService = companyService;
    }

    @Override
    public void run(final String... args) throws Exception {
        for (int i = 0; i < 50; i++) {
            Director director = generateDirector();
            generateCompany(director);
        }

        for (int i = 0; i < 50; i++) {
            Director director = generateDirector();
            generateBranch(director);
        }
    }

    private Director generateDirector() {
        Director director = new Director();
        director.setFirstName(faker.name().firstName());
        director.setLastName(faker.name().lastName());
        director.setMiddleName(faker.name().firstName());
        director.setBirthDay(faker.date().birthday());

        directorService.saveDirector(director);

        return director;
    }

    private void generateCompany(Director director) {
        Company company = new Company();
        company.setFullName(faker.company().name());
        company.setShortName(faker.company().buzzword());
        company.setTaxPayerNumber(faker.regexify("[0-9]{10}"));
        company.setMainStateRegNumber(faker.number().digits(13));
        company.setPostalAddress(faker.address().fullAddress());
        company.setLegalAddress(faker.address().fullAddress());
        company.setDirector(director);

        companyService.saveCompany(company);
    }

    private void generateBranch(Director director) {
        Branch branch = new Branch();
        branch.setFullName(faker.company().name());
        branch.setPostalAddress(faker.address().streetAddress());
        branch.setDirector(director);

        Long companyId = random.nextLong(1, companyService.getSize());
        Company foundCompany = companyService.getById(companyId);
        branch.setCompany(foundCompany);

        branchService.saveBranch(branch);
    }

}
