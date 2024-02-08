package com.sqlandjpa;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.Persistence;
import jakarta.persistence.StoredProcedureQuery;

public class Read {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pragim");
        EntityManager entityManager = emf.createEntityManager();

        /* CREATE PROCEDURE spGetEmployees AS
            BEGIN
                SELECT Name, Gender
                    FROM tblEmployee
            END; */
        // StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("spGetEmployees");        
        // List<Object[]> resultList = storedProcedureQuery.getResultList();
        // for(Object[] efl:resultList){
        //     System.out.print(efl[0] + " | ");
        //     System.out.println(efl[1]);
        // }
        
        /* CREATE PROCEDURE spGetEmployeesByGenderAndDepartment
            @Gndr nvarchar(20),
            @DptId int
            AS
            BEGIN
                SELECT Name, Gender, DepartmentId
                    FROM tblEmployee
                    WHERE Gender = @Gndr
                    AND DepartmentId = @DptId
            END; */
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("spGetEmployeesByGenderAndDepartment");   
        storedProcedureQuery.registerStoredProcedureParameter("@Gndr", String.class, ParameterMode.IN).setParameter("@Gndr", "Male");
        storedProcedureQuery.registerStoredProcedureParameter("@DptId", Integer.class, ParameterMode.IN).setParameter("@DptId", 1);
        List<Object[]> resultList = storedProcedureQuery.getResultList();
        for(Object[] efl:resultList){
            System.out.print(efl[0] + " | ");
            System.out.print(efl[1] + " | ");
            System.out.println(efl[2]);
        }
    }    
}