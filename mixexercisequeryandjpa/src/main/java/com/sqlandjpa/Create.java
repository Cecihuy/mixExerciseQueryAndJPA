package com.sqlandjpa;
import com.sqlandjpa.dto.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Create {
    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.setName("Sam");
        employee1.setGender("Male");
        employee1.setDepartmentId(1);

        Employee employee2 = new Employee();
        employee2.setName("Ram");
        employee2.setGender("Male");
        employee2.setDepartmentId(1);

        Employee employee3 = new Employee();
        employee3.setName("Sara");
        employee3.setGender("Female");
        employee3.setDepartmentId(3);

        Employee employee4 = new Employee();
        employee4.setName("Todd");
        employee4.setGender("Male");
        employee4.setDepartmentId(2);

        Employee employee5 = new Employee();
        employee5.setName("John");
        employee5.setGender("Male");
        employee5.setDepartmentId(3);

        Employee employee6 = new Employee();
        employee6.setName("Sana");
        employee6.setGender("Female");
        employee6.setDepartmentId(2);

        Employee employee7 = new Employee();
        employee7.setName("James");
        employee7.setGender("Male");
        employee7.setDepartmentId(1);

        Employee employee8 = new Employee();
        employee8.setName("Rob");
        employee8.setGender("Male");
        employee8.setDepartmentId(2);

        Employee employee9 = new Employee();
        employee9.setName("Steve");
        employee9.setGender("Male");
        employee9.setDepartmentId(1);

        Employee employee10 = new Employee();
        employee10.setName("Pam");
        employee10.setGender("Female");
        employee10.setDepartmentId(2);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pragim");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(employee1);
        entityManager.persist(employee2);
        entityManager.persist(employee3);
        entityManager.persist(employee4);
        entityManager.persist(employee5);
        entityManager.persist(employee6);
        entityManager.persist(employee7);
        entityManager.persist(employee8);
        entityManager.persist(employee9);
        entityManager.persist(employee10);
        transaction.commit();

        entityManager.close();
    }
}