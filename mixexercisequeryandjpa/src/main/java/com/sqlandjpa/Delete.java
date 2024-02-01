package com.sqlandjpa;
import com.sqlandjpa.dto.Gender;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Delete {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pragim");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        /* please pick one */
        // Gender genderToDelete = entityManager.find(Gender.class, 2);
        // Gender genderToDelete = entityManager.find(Gender.class, 1);
        Gender genderToDelete = entityManager.find(Gender.class, 3);

        transaction.begin();        
        entityManager.remove(genderToDelete);
        transaction.commit();        

        entityManager.close();
    }
}