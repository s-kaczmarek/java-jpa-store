package service.repository;

import entity.Product;
import utils.HibernateUtils;

import java.util.List;

public class ProductRepository extends AbstractRepository<Long, Product> {

    private static ProductRepository instance;

    public static ProductRepository getInstance(){
        if(instance == null){
            instance = new ProductRepository();
        }
        return instance;
    }

    public ProductRepository(){
        super();
    }

    @Override
    public List<Product> readAllObjects() {
        String query = String.format("SELECT e FROM Product e");
        return HibernateUtils.entityManager.createQuery(query).getResultList();
    }
}
