package service.repository;

import entity.Product;
import utils.HibernateUtils;

import java.util.List;

public class ProductRepository extends AbstractRepository<Long, Product> {

    public ProductRepository(){
        super();
    }
}
