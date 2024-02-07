package com.sqlandjpa;
import com.sqlandjpa.dto.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Create {
    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.setName("Mike");

        Employee employee2 = new Employee();
        employee2.setName("Rob");

        Employee employee3 = new Employee();
        employee3.setName("Todd");

        Employee employee4 = new Employee();
        employee4.setName("Ben");

        Employee employee5 = new Employee();
        employee5.setName("Sam");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pragim");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(employee1);
        entityManager.persist(employee2);
        entityManager.persist(employee3);
        entityManager.persist(employee4);
        entityManager.persist(employee5);
        employee2.setManagerId(employee1.getEmployeeId());
        employee1.setManagerId(employee3.getEmployeeId());
        employee4.setManagerId(employee1.getEmployeeId());
        employee5.setManagerId(employee1.getEmployeeId());
        transaction.commit();        

        entityManager.close();
    }
}