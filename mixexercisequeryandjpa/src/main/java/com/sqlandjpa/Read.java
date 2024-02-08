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

        /* SELECT id, COALESCE(FirstName, MiddleName, LastName) AS Name
	        FROM tblEmployee; */
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        CriteriaQuery<Object[]> selectFirstNonNull = criteriaQuery.multiselect(
            root.get("id")
            , builder.coalesce(root.get("firstName")
                , builder.coalesce(root.get("middleName"), root.get("lastName"))));
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(selectFirstNonNull);
        List<Object[]> resultList = typedQuery.getResultList();
        for(Object[] efl:resultList){
            System.out.print(efl[0] + " | ");
            System.out.println(efl[1]);
        }
    }    
}