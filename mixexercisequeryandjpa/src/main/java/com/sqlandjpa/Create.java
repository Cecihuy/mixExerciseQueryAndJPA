package com.sqlandjpa;
import com.sqlandjpa.dto.Gender;
import com.sqlandjpa.dto.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Create {
    public static void main(String[] args) {
        Gender gender1 = new Gender();
        gender1.setGender("Male");

        Gender gender2 = new Gender();
        gender2.setGender("Female");

        Gender gender3 = new Gender();
        gender3.setGender("Unknown");

        Person person1 = new Person();
        person1.setName("John");
        person1.setEmail("j@j.com");
        person1.setAge(1);

        Person person2 = new Person();
        person2.setName("Ron");
        person2.setEmail("rrrr.com");
        person2.setGenderId(gender1);
        person2.setAge(1);

        Person person3 = new Person();
        person3.setName("Rich");
        person3.setEmail("r@r.com");
        person3.setAge(1);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pragim");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(gender1);
        entityManager.persist(gender2);
        entityManager.persist(gender3);
        entityManager.persist(person1);
        entityManager.persist(person2);
        entityManager.persist(person3);
        transaction.commit();        

        entityManager.close();
    }
}