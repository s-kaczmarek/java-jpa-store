package service.repository;

import entity.Product;
import utils.HibernateUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

// T = id
// U = entity name
public abstract class AbstractRepository<T, U> {

    protected Class<U> type;

    @SuppressWarnings("unchecked") // For the cast on Class<E>.
    public AbstractRepository() {
        // U jest klasą persystowaną i jest wykozystywana do wykonywania operacji CRUD. Blok kodu poniżej pozwala uzustakć typ klasy, do przekazania w metodach
        Type type = getClass().getGenericSuperclass();

        while (!(type instanceof ParameterizedType) || ((ParameterizedType) type).getRawType() != AbstractRepository.class) {
            if (type instanceof ParameterizedType) {
                type = ((Class<?>) ((ParameterizedType) type).getRawType()).getGenericSuperclass();
            } else {
                type = ((Class<?>) type).getGenericSuperclass();
            }
        }

        this.type = (Class<U>) ((ParameterizedType) type).getActualTypeArguments()[0];
    }

    public void persistObject(Object object){
        HibernateUtils.persistObject(object);
    }

    public abstract List<U> readAllSales();

    public Object readObjectById(T id){
        Class<U> entityClass;
        Object retrievedObject = HibernateUtils.readObjectById(type.getClass(), id);
        return retrievedObject;
    }

    public void updateObject(Object object){
        HibernateUtils.updateObject(object);
    }

    public void deleteObject(Object object){
        HibernateUtils.deleteObject(object);
    }
}
