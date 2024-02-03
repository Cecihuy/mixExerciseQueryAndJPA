package com.sqlandjpa.dto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblPerson")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;
    @Column(name = "Name", length = 50)
    private String name;
    @Column(name = "Email", length = 50)    
    private String email;    
    @ManyToOne
    @JoinColumn(name = "GenderID")
    private Gender genderId;
    @Column(name = "Age")
    private int age;
    @Column(name= "City", length = 50)
    private String city;
        
    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", email=" + email + ", genderId=" + genderId.getId() + ", age=" + age
                + ", city=" + city + "]\n";
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Gender getGenderId() {
        return genderId;
    }    
    public void setGenderId(Gender genderId) {
        this.genderId = genderId;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}