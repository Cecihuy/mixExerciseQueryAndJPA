package com.sqlandjpa;
import java.util.List;
import com.sqlandjpa.dto.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class Read {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pragim");
        EntityManager entityManager = emf.createEntityManager();

        /* SELECT * FROM tblPerson; */
        // CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        // CriteriaQuery<Person> criteria = builder.createQuery(Person.class);
        // Root<Person> root = criteria.from(Person.class);
        // CriteriaQuery<Person> selectAll = criteria.select(root);
        // TypedQuery<Person> typedQuery = entityManager.createQuery(selectAll);
        // List<Person> resultList = typedQuery.getResultList();

        /* SELECT DISTINCT City FROM tblPerson; */
        // CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        // CriteriaQuery<String> criteria = builder.createQuery(String.class);
        // Root<Person> root = criteria.from(Person.class);
        // CriteriaQuery<String> selectDistinct = criteria.select(root.get("city")).distinct(true);
        // TypedQuery<String> typedQuery = entityManager.createQuery(selectDistinct);
        // List<String> resultList = typedQuery.getResultList();

        /* SELECT * FROM tblPerson WHERE City != 'London'; */
        // CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        // CriteriaQuery<Person> criteria = builder.createQuery(Person.class);
        // Root<Person> root = criteria.from(Person.class);
        // CriteriaQuery<Person> selectWhere = criteria.where(builder.notEqual(root.get("city"), "London"));
        // TypedQuery<Person> typedQuery = entityManager.createQuery(selectWhere);
        // List<Person> resultList = typedQuery.getResultList();

        /* SELECT * FROM tblPerson WHERE Age IN(20, 23, 29); */
        // CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        // CriteriaQuery<Person> criteria = builder.createQuery(Person.class);
        // Root<Person> root = criteria.from(Person.class);
        // CriteriaQuery<Person> selectIn = criteria.where(root.get("age").in(20, 23, 29));
        // TypedQuery<Person> typedQuery = entityManager.createQuery(selectIn);
        // List<Person> resultList = typedQuery.getResultList();

        /* SELECT * FROM tblPerson WHERE Age BETWEEN 20 AND 25; */
        // CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        // CriteriaQuery<Person> criteria = builder.createQuery(Person.class);
        // Root<Person> root = criteria.from(Person.class);
        // CriteriaQuery<Person> selectBetween = criteria.where(builder.between(root.get("age"), 20, 25));
        // TypedQuery<Person> typedQuery = entityManager.createQuery(selectBetween);
        // List<Person> resultList = typedQuery.getResultList();

        /* SELECT * FROM tblPerson	WHERE Email NOT LIKE '_@_.com'; */
        // CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        // CriteriaQuery<Person> criteria = builder.createQuery(Person.class);
        // Root<Person> root = criteria.from(Person.class);
        // CriteriaQuery<Person> selectNotLike = criteria.where(builder.notLike(root.get("email"), "_@_.com"));
        // TypedQuery<Person> typedQuery = entityManager.createQuery(selectNotLike);
        // List<Person> resultList = typedQuery.getResultList();

        /* SELECT * FROM tblPerson WHERE (City = 'London' OR City = 'Mumbai') AND Age > 25; */
        // CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        // CriteriaQuery<Person> criteria = builder.createQuery(Person.class);
        // Root<Person> root = criteria.from(Person.class);
        // Predicate londonPred = builder.like(root.get("city"),"London");
        // Predicate mumbaiPred = builder.like(root.get("city"),"Mumbai");
        // Predicate orPred = builder.or(londonPred, mumbaiPred);
        // Predicate gtPred = builder.gt(root.get("age"), 25);
        // CriteriaQuery<Person> selectCondition = criteria.where(builder.and(orPred, gtPred));
        // TypedQuery<Person> typedQuery = entityManager.createQuery(selectCondition);
        // List<Person> resultList = typedQuery.getResultList();

        /* SELECT * FROM tblPerson ORDER BY City ASC, Age DESC; */
        // CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        // CriteriaQuery<Person> criteria = builder.createQuery(Person.class);
        // Root<Person> root = criteria.from(Person.class);
        // CriteriaQuery<Person> selectOrder = criteria.orderBy(builder.asc(root.get("city")), builder.desc(root.get("age")));
        // TypedQuery<Person> typedQuery = entityManager.createQuery(selectOrder);
        // List<Person> resultList = typedQuery.getResultList();

        /* SELECT TOP 3 Name, Age FROM tblPerson; */
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteria = builder.createTupleQuery();
        Root<Person> root = criteria.from(Person.class);
        CriteriaQuery<Tuple> selectLimit = criteria.multiselect(root.get("name"), root.get("age"));
        TypedQuery<Tuple> typedQuery = entityManager.createQuery(selectLimit).setMaxResults(3);
        List<Tuple> resultList = typedQuery.getResultList();

        /* print the result of your choice */
        System.out.println(resultList);
    }
}
