package com.sqlandjpa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.Persistence;
import jakarta.persistence.StoredProcedureQuery;

public class Read {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pragim");
        EntityManager entityManager = emf.createEntityManager();        
        
        /* CREATE PROCEDURE spGetEmployeeCountByGender
            @Gndr NVARCHAR(20),
            @EmpCount INT OUTPUT
            AS
            BEGIN
                SELECT @EmpCount = COUNT(Id) 
                    FROM tblEmployee
                    WHERE Gender = @Gndr
            END; */
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("spGetEmployeeCountByGender");   
        storedProcedureQuery.registerStoredProcedureParameter("@Gndr", String.class, ParameterMode.IN).setParameter("@Gndr", "Male");
        storedProcedureQuery.registerStoredProcedureParameter("@EmpCount", Integer.class, ParameterMode.OUT);        
        Object countResult = storedProcedureQuery.getOutputParameterValue("@EmpCount");     // actual result is Integer. we can type cast it
        System.out.println(countResult);
    }    
}