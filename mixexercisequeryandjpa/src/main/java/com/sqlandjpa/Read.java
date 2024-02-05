package com.sqlandjpa;
import java.util.List;
import com.sqlandjpa.dto.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class Read {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pragim");
        EntityManager entityManager = emf.createEntityManager();

        /* SELECT SUM(Salary) FROM tblEmployee; */
        // CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        // CriteriaQuery<Number> criteriaQuery = builder.createQuery(Number.class);
        // Root<Employee> root = criteriaQuery.from(Employee.class);
        // CriteriaQuery<Number> selectSum = criteriaQuery.select(builder.sum(root.get("salary")));
        // TypedQuery<Number> typedQuery = entityManager.createQuery(selectSum);
        // List<Number> resultList = typedQuery.getResultList();
        // System.out.println(resultList);

        /* SELECT City, SUM(Salary) AS TotalSalary FROM tblEmployee GROUP BY City; */
        // CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        // CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
        // Root<Employee> root = criteriaQuery.from(Employee.class);        
        // CriteriaQuery<Object[]> selectGroupBy = criteriaQuery.multiselect(root.get("city"), builder.sum(root.get("salary"))).groupBy(root.get("city"));
        // TypedQuery<Object[]> typedQuery = entityManager.createQuery(selectGroupBy);
        // List<Object[]> resultList = typedQuery.getResultList();
        // for(Object[] efl: resultList){
        //     System.out.print(efl[0] + " = ");
        //     System.out.println(efl[1]);
        // }

        /* SELECT City, Gender, SUM(Salary) AS TotalSalary FROM tblEmployee	GROUP BY City, Gender ORDER BY City ASC; */
        // CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        // CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
        // Root<Employee> root = criteriaQuery.from(Employee.class);        
        // CriteriaQuery<Object[]> selectGroupBy =
        //     criteriaQuery.multiselect(
        //         root.get("city")
        //         , root.get("gender")
        //         , builder.sum(root.get("salary")))
        //             .groupBy(root.get("city")
        //                 , root.get("gender"))
        //                     .orderBy(builder.asc(root.get("city")));
        // TypedQuery<Object[]> typedQuery = entityManager.createQuery(selectGroupBy);
        // List<Object[]> resultList = typedQuery.getResultList();
        // for(Object[] efl: resultList){
        //     System.out.print(efl[0] + " | ");
        //     System.out.print(efl[1] + " | ");
        //     System.out.println(efl[2]);
        // }

        /* SELECT COUNT(ID) FROM tblEmployee; */
        // CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        // CriteriaQuery<Number> criteriaQuery = builder.createQuery(Number.class);
        // Root<Employee> root = criteriaQuery.from(Employee.class);
        // CriteriaQuery<Number> selectSum = criteriaQuery.select(builder.count(root));
        // TypedQuery<Number> typedQuery = entityManager.createQuery(selectSum);
        // List<Number> resultList = typedQuery.getResultList();
        // System.out.println(resultList);

        /* SELECT City, Gender, SUM(Salary) AS TotalSalary, COUNT(ID) AS [Total Employees]
	        FROM tblEmployee
        	GROUP BY City, Gender
	        ORDER BY City ASC; */
        // CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        // CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
        // Root<Employee> root = criteriaQuery.from(Employee.class);        
        // CriteriaQuery<Object[]> selectGroupBy =
        //     criteriaQuery.multiselect(
        //         root.get("city")
        //         , root.get("gender")
        //         , builder.sum(root.get("salary"))
        //         , builder.count(root))
        //             .groupBy(root.get("city")
        //                 , root.get("gender"))
        //                     .orderBy(builder.asc(root.get("city")));
        // TypedQuery<Object[]> typedQuery = entityManager.createQuery(selectGroupBy);
        // List<Object[]> resultList = typedQuery.getResultList();
        // for(Object[] efl: resultList){
        //     System.out.print(efl[0] + " | ");
        //     System.out.print(efl[1] + " | ");
        //     System.out.print(efl[2] + " | ");
        //     System.out.println(efl[3]);
        // }

        /* SELECT City, Gender, SUM(Salary) AS TotalSalary, COUNT(ID) AS [Total Employees]
	            FROM tblEmployee
	            GROUP BY City, Gender
	            HAVING SUM(Salary) > 5000
	            ORDER BY City ASC; */
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
        Root<Employee> root = criteriaQuery.from(Employee.class);        
        CriteriaQuery<Object[]> selectGroupBy =
            criteriaQuery.multiselect(
                root.get("city")
                , root.get("gender")
                , builder.sum(root.get("salary"))
                , builder.count(root))
                    .groupBy(root.get("city")
                        , root.get("gender"))
                            .having(builder.gt(builder.sum(root.get("salary")), 5000))
                                .orderBy(builder.asc(root.get("city")));
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(selectGroupBy);
        List<Object[]> resultList = typedQuery.getResultList();
        for(Object[] efl: resultList){
            System.out.print(efl[0] + " | ");
            System.out.print(efl[1] + " | ");
            System.out.print(efl[2] + " | ");
            System.out.println(efl[3]);
        }
    }    
}