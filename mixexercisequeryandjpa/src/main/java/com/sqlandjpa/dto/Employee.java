package com.sqlandjpa.dto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblEmployee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private Integer id;
    @Column(name = "FirstName", nullable = true)
    private String firstName;
    @Column(name = "MiddleName", nullable = true)
    private String middleName;
    @Column(name = "LastName", nullable = true)
    private String lastName;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        lastName = lastName;
    }
}