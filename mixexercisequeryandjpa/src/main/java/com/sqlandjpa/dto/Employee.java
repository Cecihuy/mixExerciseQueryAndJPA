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
    private Integer employeeId;
    @Column(name = "Name", length = 20)
    private String name;
    @Column(name = "ManagerID", nullable = true, columnDefinition = "INT DEFAULT NULL", insertable = false)
    private Integer managerId;

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", name=" + name + ", managerId=" + managerId + "]";
    }
    public Integer getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getManagerId() {
        return managerId;
    }    
    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }
}