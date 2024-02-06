package com.sqlandjpa;
import com.sqlandjpa.dto.Department;
import com.sqlandjpa.dto.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Create {
    public static void main(String[] args) {
        Department department1 = new Department();
        department1.setName("IT");
        department1.setLocation("London");
        department1.setHead("Rick");

        Department department2 = new Department();
        department2.setName("Payroll");
        department2.setLocation("Delhi");
        department2.setHead("Ron");

        Department department3 = new Department();
        department3.setName("HR");
        department3.setLocation("New York");
        department3.setHead("Christie");

        Department department4 = new Department();
        department4.setName("Other Department");
        department4.setLocation("Sydney");
        department4.setHead("Cindrella");
        
        Employee employee1 = new Employee();
        employee1.setName("Tom");
        employee1.setGender("Male");
        employee1.setSalary(4000);        
        employee1.setDepartId(department1);

        Employee employee2 = new Employee();
        employee2.setName("Pam");
        employee2.setGender("Female");
        employee2.setSalary(3000);        
        employee2.setDepartId(department3);

        Employee employee3 = new Employee();
        employee3.setName("John");
        employee3.setGender("Male");
        employee3.setSalary(3500);
        employee3.setDepartId(department1);
        
        Employee employee4 = new Employee();
        employee4.setName("Sam");
        employee4.setGender("Male");
        employee4.setSalary(4500);
        employee4.setDepartId(department2);

        Employee employee5 = new Employee();
        employee5.setName("Todd");
        employee5.setGender("Male");
        employee5.setSalary(2800);
        employee5.setDepartId(department2);

        Employee employee6 = new Employee();
        employee6.setName("Ben");
        employee6.setGender("Male");
        employee6.setSalary(7000);
        employee6.setDepartId(department1);

        Employee employee7 = new Employee();
        employee7.setName("Sara");
        employee7.setGender("Female");
        employee7.setSalary(4800);
        employee7.setDepartId(department3);

        Employee employee8 = new Employee();
        employee8.setName("Valarie");
        employee8.setGender("Female");
        employee8.setSalary(5500);
        employee8.setDepartId(department1);

        Employee employee9 = new Employee();
        employee9.setName("James");
        employee9.setGender("Male");
        employee9.setSalary(6500);

        Employee employee10 = new Employee();
        employee10.setName("Russell");
        employee10.setGender("Male");
        employee10.setSalary(8800);        

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pragim");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(department1);
        entityManager.persist(department2);
        entityManager.persist(department3);
        entityManager.persist(department4);
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