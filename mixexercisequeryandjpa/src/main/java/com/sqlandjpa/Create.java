package com.sqlandjpa;
import com.sqlandjpa.dto.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Create {
    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.setFirstName("Sam");

        Employee employee2 = new Employee();
        employee2.setMiddleName("Todd");
        employee2.setLastName("Tanzan");

        Employee employee3 = new Employee();
        employee3.setLastName("Sara");

        Employee employee4 = new Employee();
        employee4.setFirstName("Ben");
        employee4.setMiddleName("Parker");

        Employee employee5 = new Employee();
        employee5.setFirstName("James");
        employee5.setMiddleName("Nick");
        employee5.setLastName("Nancy");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pragim");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(employee1);
        entityManager.persist(employee2);
        entityManager.persist(employee3);
        entityManager.persist(employee4);
        entityManager.persist(employee5);
        transaction.commit();        

        entityManager.close();
    }
}