package service.repository;

import entity.Sale;
import utils.HibernateUtils;

import java.util.List;

public class SaleRepository extends AbstractRepository<Long, Sale>{

    private static SaleRepository instance;

    public static SaleRepository getInstance(){
        if(instance == null){
            instance = new SaleRepository();
        }
        return instance;
    }

    public SaleRepository() {
        super();
    }

    @Override
    public List<Sale> readAllObjects() {
        String query = String.format("SELECT e FROM Sale e");
        return HibernateUtils.entityManager.createQuery(query).getResultList();
    }
}
