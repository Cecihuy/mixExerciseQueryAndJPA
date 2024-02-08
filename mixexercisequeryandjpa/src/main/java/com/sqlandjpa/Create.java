package com.sqlandjpa;
import com.sqlandjpa.dto.India;
import com.sqlandjpa.dto.Kingdom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Create {
    public static void main(String[] args) {
        India india1 = new India();
        india1.setName("Raj");
        india1.setEmail("R@R.com");

        India india2 = new India();
        india2.setName("Sam");
        india2.setEmail("S@S.com");

        Kingdom kingdom1 = new Kingdom();
        kingdom1.setName("Ben");
        kingdom1.setEmail("B@B.com");

        Kingdom kingdom2 = new Kingdom();
        kingdom2.setName("Sam");
        kingdom2.setEmail("S@S.com");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pragim");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(india1);
        entityManager.persist(india2);
        entityManager.persist(kingdom1);
        entityManager.persist(kingdom2);
        transaction.commit();

        entityManager.close();
    }
}