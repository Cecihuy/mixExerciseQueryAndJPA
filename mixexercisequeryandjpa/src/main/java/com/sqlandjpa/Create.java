package com.sqlandjpa;
import com.sqlandjpa.dto.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Create {
    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.setName("Tom");
        employee1.setGender("Male");
        employee1.setSalary(4000);
        employee1.setCity("London");

        Employee employee2 = new Employee();
        employee2.setName("Pam");
        employee2.setGender("Female");
        employee2.setSalary(3000);
        employee2.setCity("New York");

        Employee employee3 = new Employee();
        employee3.setName("John");
        employee3.setGender("Male");
        employee3.setSalary(3500);
        employee3.setCity("London");

        Employee employee4 = new Employee();
        employee4.setName("Sam");
        employee4.setGender("Male");
        employee4.setSalary(4500);
        employee4.setCity("London");

        Employee employee5 = new Employee();
        employee5.setName("Todd");
        employee5.setGender("Male");
        employee5.setSalary(2800);
        employee5.setCity("Sydney");

        Employee employee6 = new Employee();
        employee6.setName("Ben");
        employee6.setGender("Male");
        employee6.setSalary(7000);
        employee6.setCity("New York");

        Employee employee7 = new Employee();
        employee7.setName("Sara");
        employee7.setGender("Female");
        employee7.setSalary(4800);
        employee7.setCity("Sydney");

        Employee employee8 = new Employee();
        employee8.setName("Valarie");
        employee8.setGender("Female");
        employee8.setSalary(5500);
        employee8.setCity("New York");

        Employee employee9 = new Employee();
        employee9.setName("James");
        employee9.setGender("Male");
        employee9.setSalary(6500);
        employee9.setCity("London");

        Employee employee10 = new Employee();
        employee10.setName("Russell");
        employee10.setGender("Male");
        employee10.setSalary(8800);
        employee10.setCity("London");        

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