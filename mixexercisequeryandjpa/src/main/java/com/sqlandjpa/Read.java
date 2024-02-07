package com.sqlandjpa;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Read {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pragim");
        EntityManager entityManager = emf.createEntityManager();

        /* SELECT L.Name AS Employee, COALESCE(R.Name, 'No Manager') AS Manager
            FROM tblEmployee L
            LEFT JOIN tblEmployee R
            ON L.ManagerID = R.EmployeeID; */
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(            
            "SELECT L.name," +
                " COALESCE(R.name, 'No Manager')" +
                " FROM Employee L" +
                " LEFT JOIN Employee R" +
                " ON L.managerId = R.employeeId"
            ,Object[].class);
        List<Object[]> resultList = typedQuery.getResultList();
        for(Object[] efl:resultList){
            System.out.print(efl[0] + " | ");
            System.out.println(efl[1]);
        }
        /* code above is using JPQL, criteria API later for time being */
    }    
}