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

        Person person1 = new Person();
        person1.setName("Tom");
        person1.setEmail("t@t.com");
        person1.setGenderId(gender1);
        person1.setAge(23);
        person1.setCity("London");

        Person person2 = new Person();
        person2.setName("John");
        person2.setEmail("john@j.com");
        person2.setGenderId(gender1);
        person2.setAge(20);
        person2.setCity("New York");

        Person person3 = new Person();
        person3.setName("Mary");
        person3.setEmail("m@m.com");
        person3.setGenderId(gender2);
        person3.setAge(21);
        person3.setCity("Sydney");

        Person person4 = new Person();
        person4.setName("Josh");
        person4.setEmail("josh@j.com");
        person4.setGenderId(gender1);
        person4.setAge(29);
        person4.setCity("London");

        Person person5 = new Person();
        person5.setName("Sara");
        person5.setEmail("s@s.com");
        person5.setGenderId(gender2);
        person5.setAge(25);
        person5.setCity("Mumbai");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pragim");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(gender1);
        entityManager.persist(gender2);
        entityManager.persist(person1);
        entityManager.persist(person2);
        entityManager.persist(person3);
        entityManager.persist(person4);
        entityManager.persist(person5);
        transaction.commit();        

        entityManager.close();
    }
}