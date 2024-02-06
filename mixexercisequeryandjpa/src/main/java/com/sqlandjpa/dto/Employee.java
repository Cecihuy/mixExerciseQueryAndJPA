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
@Table(name = "tblEmployee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;
    @Column(name = "Name", length = 50)
    private String name;
    @Column(name = "Gender")
    private String gender;    
    @Column(name = "Salary")
    private int salary;
    @ManyToOne
    @JoinColumn(name= "DepartmentId", nullable = true, columnDefinition = "INT default NULL")
    private Department departId;
    
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", salary=" + salary + ", departId="
                + departId + "]";
    }
    public Department getDepartId() {
        return departId;
    }
    public void setDepartId(Department departId) {
        this.departId = departId;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
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
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
}