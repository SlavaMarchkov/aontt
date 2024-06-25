package ru.pmgu.aontt.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "directors")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String middleName;
    private Date birthDay;

    public Director() {

    }

    public Director(final Date birthDay,
                    final String firstName,
                    final String lastName,
                    final String middleName) {
        this.birthDay = birthDay;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(final Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(final String middleName) {
        this.middleName = middleName;
    }

    @Override
    public String toString() {
        return "Director{" +
               "id=" + id +
               ", birthDay=" + birthDay +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", middleName='" + middleName + '\'' +
               '}';
    }

}
