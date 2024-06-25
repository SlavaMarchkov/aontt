package ru.pmgu.aontt.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.pmgu.aontt.entity.Company;
import ru.pmgu.aontt.service.CompanyService;

import java.util.List;

@RestController
@Tag(name = "Контроллер по работе с организациями")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(final CompanyService companyService) {
        this.companyService = companyService;
    }

    @Operation(
            summary = "Получение списка всех организаций",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Список всех организаций",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = Company.class))
                            )
                    )
            }
    )
    @GetMapping(path = "/companies") // GET http://localhost:8080/companies
    public ResponseEntity<List<Company>> getAllCompanies() {
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @Operation(
            summary = "Поиск организации по id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Найденная организация по id",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Company.class)
                            )
                    )
            }
    )
    @GetMapping("/companies/{id}") // GET http://localhost:8080/companies/1
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        Company company = companyService.getCompanyById(id);
        if (company == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(company);
    }

}
