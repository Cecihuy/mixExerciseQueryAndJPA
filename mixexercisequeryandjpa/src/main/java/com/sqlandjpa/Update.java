package com.sqlandjpa;
import com.sqlandjpa.dto.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Update {
    public static void main(String[] args) {

        Person person = new Person();
        person.setName("Chuck");
        person.setEmail("c@c.com");
        /* pick one. uncomment double slash */
        // person.setAge(222);
        person.setAge(25);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pragim");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();        

        transaction.begin();        
        entityManager.persist(person);
        transaction.commit();        

        entityManager.close();
    }
}