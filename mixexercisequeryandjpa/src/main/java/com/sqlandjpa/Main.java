package com.sqlandjpa;
import com.sqlandjpa.dto.Gender;
import com.sqlandjpa.dto.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
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
        person1.setGenderId(gender1);

        Person person2 = new Person();
        person2.setName("Mary");
        person2.setEmail("m@m.com");
        person2.setGenderId(gender2);

        Person person3 = new Person();
        person3.setName("Simon");
        person3.setEmail("s@s.com");
        person3.setGenderId(gender1);

        Person person4 = new Person();
        person4.setName("Sam");
        person4.setEmail("sam@sam.com");
        person4.setGenderId(gender1);

        Person person5 = new Person();
        person5.setName("May");
        person5.setEmail("may@may.com");
        person5.setGenderId(gender2);

        Person person6 = new Person();
        person6.setName("Kenny");
        person6.setEmail("k@k.com");
        person6.setGenderId(gender3);

        Person person7 = new Person();
        person7.setName("Rich");
        person7.setEmail("r@r.com");
        person7.setGenderId(null);

        //problem : on initialization, person8.setGenderId is always set to null instead unset
        Person person8 = new Person();
        person8.setName("Mike");
        person8.setEmail("mike@r.com");
        // person8.setGenderId(apaHayooo?);

        Person person9 = new Person();
        person9.setName("Sara");
        person9.setEmail("s@r.com");
        person9.setGenderId(gender1);

        Person person10 = new Person();
        person10.setName("Johnny");
        person10.setEmail("j@r.com");
        person10.setGenderId(null);

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
        entityManager.persist(person4);
        entityManager.persist(person5);
        entityManager.persist(person6);
        entityManager.persist(person7);
        entityManager.persist(person8);
        entityManager.persist(person9);
        entityManager.persist(person10);
        transaction.commit();        

        entityManager.close();
    }
}