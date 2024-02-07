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
    @Column(name = "EmployeeID")
    private int employeeId;
    @Column(name = "Name", length = 20)
    private String name;    
    @Column(name = "ManagerID", nullable = true, columnDefinition = "INT DEFAULT NULL", insertable = false)
    private int managerId;    

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", name=" + name + ", managerId=" + managerId + "]";
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getManagerId() {
        return managerId;
    }    
    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }
}