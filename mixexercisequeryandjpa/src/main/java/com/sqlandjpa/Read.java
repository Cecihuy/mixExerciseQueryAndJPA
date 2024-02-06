package com.sqlandjpa;
import java.util.List;
import com.sqlandjpa.dto.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

public class Read {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pragim");
        EntityManager entityManager = emf.createEntityManager();

        /* SELECT Name, Gender, Salary, DepartmentName
	        FROM tblEmployee
	        INNER JOIN tblDepartment
	        ON tblEmployee.DepartmentId = tblDepartment.id; */        
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
        Root<Employee> rootEmployee = criteriaQuery.from(Employee.class);
        CriteriaQuery<Object[]> selectInnerJoin = criteriaQuery.multiselect(
            rootEmployee.get("name")
            , rootEmployee.get("gender")
            , rootEmployee.get("salary")
            , rootEmployee.join("departId", JoinType.INNER).get("name") //just change JoinType to INNER, LEFT, or RIGHT
            );
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(selectInnerJoin);
        List<Object[]> resultList = typedQuery.getResultList();
        for(Object[] efl:resultList){
            System.out.print(efl[0] + " | ");
            System.out.print(efl[1] + " | ");
            System.out.print(efl[2] + " | ");
            System.out.println(efl[3]);
        }        
    }    
}