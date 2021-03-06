package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class HibernateUtils {

    private static final EntityManagerFactory entityManagerFactory;
    public static final EntityManager entityManager;

    public static final Double PI = 3.14;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("pu");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static void persistObject(Object object){
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
        entityManager.clear();
    }

    public static List readAllObjects(String entityName){
        List<Object> retrievedObjects = new ArrayList<>();
        String query = String.format("SELECT e FROM %e e",entityName);
        return retrievedObjects = entityManager.createQuery(query).getResultList();
    }

    public static Object readObjectById(Class entity, Object id){
        Object retrievedObject = entityManager.getReference(entity, id);
        return retrievedObject;
    }

    public static void updateObject(Object object){
        entityManager.getTransaction().begin();
        entityManager.merge(object);
        entityManager.getTransaction().commit();
    }

    public static void deleteObject(Object object){
        entityManager.getTransaction().begin();
        entityManager.remove(object);
        entityManager.getTransaction().commit();
    }

    public static void closeSession(){
        entityManager.close();
        entityManagerFactory.close();
    }

}
