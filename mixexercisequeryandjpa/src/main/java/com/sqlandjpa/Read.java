package com.sqlandjpa;
import java.util.List;
import com.sqlandjpa.dto.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class Read {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pragim");
        EntityManager entityManager = emf.createEntityManager();

        /* code below is alternate for query:
        SELECT L.Name AS Employee, R.Name AS Manager
            FROM tblEmployee L
            JOIN tblEmployee R
            ON L.ManagerID = R.EmployeeID; */        
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
        Root<Employee> rootEmployeeL = criteriaQuery.from(Employee.class);
        Root<Employee> rootEmployeeR = criteriaQuery.from(Employee.class);        
        CriteriaQuery<Object[]> selectInnerJoin = criteriaQuery.multiselect(
            rootEmployeeL.get("name")
            , rootEmployeeR.get("name")
            ).where(builder.equal(rootEmployeeR.get("employeeId"), rootEmployeeL.get("managerId")));        
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(selectInnerJoin);
        List<Object[]> resultList = typedQuery.getResultList();
        for(Object[] efl:resultList){
            System.out.print(efl[0] + " | ");
            System.out.println(efl[1]);
        }
    }    
}