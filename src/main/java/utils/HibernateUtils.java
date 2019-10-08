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
        System.out.println("URUCHOMIONO BLOK STATIC");
    }

    public static void persistObject(Object object){
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
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
        entityManager.merge(object);
    }

    public static void deleteObject(Object object){
        entityManager.remove(object);
    }

    public static void closeSession(){
        entityManager.close();
        entityManagerFactory.close();
    }

}
