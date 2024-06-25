package ru.pmgu.aontt.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String shortName;
    private String taxPayerNumber;
    private String mainStateRegNumber;
    private String postalAddress;
    private String legalAddress;

    @OneToOne
    @JoinColumn(name = "director_id")
    private Director director;

    @OneToMany(mappedBy = "company")
    private List<Branch> branches;

    public Company() {

    }

    public Company(final String fullName,
                   final String legalAddress,
                   final String mainStateRegNumber,
                   final String postalAddress,
                   final String shortName,
                   final String taxPayerNumber) {
        this.fullName = fullName;
        this.legalAddress = legalAddress;
        this.mainStateRegNumber = mainStateRegNumber;
        this.postalAddress = postalAddress;
        this.shortName = shortName;
        this.taxPayerNumber = taxPayerNumber;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(final List<Branch> branches) {
        this.branches = branches;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(final Director director) {
        this.director = director;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getLegalAddress() {
        return legalAddress;
    }

    public void setLegalAddress(final String legalAddress) {
        this.legalAddress = legalAddress;
    }

    public String getMainStateRegNumber() {
        return mainStateRegNumber;
    }

    public void setMainStateRegNumber(final String mainStateRegNumber) {
        this.mainStateRegNumber = mainStateRegNumber;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(final String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(final String shortName) {
        this.shortName = shortName;
    }

    public String getTaxPayerNumber() {
        return taxPayerNumber;
    }

    public void setTaxPayerNumber(final String taxPayerNumber) {
        this.taxPayerNumber = taxPayerNumber;
    }

    @Override
    public String toString() {
        return "Company{" +
               "id=" + id +
               ", fullName='" + fullName + '\'' +
               ", shortName='" + shortName + '\'' +
               ", taxPayerNumber='" + taxPayerNumber + '\'' +
               ", mainStateRegNumber='" + mainStateRegNumber + '\'' +
               ", postalAddress='" + postalAddress + '\'' +
               ", legalAddress='" + legalAddress + '\'' +
               ", director=" + director +
               '}';
    }
}