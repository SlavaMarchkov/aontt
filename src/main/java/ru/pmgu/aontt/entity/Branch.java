package ru.pmgu.aontt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "branches")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String postalAddress;

    @OneToOne
    @JoinColumn(name = "director_id")
    private Director director;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;

    public Branch() {

    }

    public Branch(final String fullName,
                  final String postalAddress) {
        this.fullName = fullName;
        this.postalAddress = postalAddress;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(final Company company) {
        this.company = company;
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

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(final String postalAddress) {
        this.postalAddress = postalAddress;
    }

    @Override
    public String toString() {
        return "Branch{" +
               "id=" + id +
               ", fullName='" + fullName + '\'' +
               ", postalAddress='" + postalAddress + '\'' +
               ", director=" + director +
               '}';
    }

}
