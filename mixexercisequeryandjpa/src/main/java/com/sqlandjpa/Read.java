package com.sqlandjpa;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Read {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pragim");
        EntityManager entityManager = emf.createEntityManager();

        /* SELECT*FROM tblIndiaCustomers
            UNION ALL
            SELECT*FROM tblKingdomCustomers
            ORDER BY Name DESC; */
        Query nativeQuery = entityManager.createNativeQuery(
            "SELECT*FROM tblIndiaCustomers" +
                " UNION ALL" +
                " SELECT*FROM tblKingdomCustomers" +
                " ORDER BY Name DESC"
            );
        List<Object[]> resultList = nativeQuery.getResultList();
        for(Object[] efl:resultList){
            System.out.print(efl[0] + " | ");
            System.out.print(efl[1] + " | ");
            System.out.println(efl[2]);
        }
        /* code above is using native query, UNION doesn't support in criteria API nor JPQL at this time*/
    }    
}