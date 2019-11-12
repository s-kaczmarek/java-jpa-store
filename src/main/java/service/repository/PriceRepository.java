package service.repository;

import entity.Price;
import utils.HibernateUtils;

import java.util.List;

public class PriceRepository extends AbstractRepository<Long, Price> {

    private static PriceRepository instance;

    public static PriceRepository getInstance(){
        if(instance == null){
            instance = new PriceRepository();
        }
        return instance;
    }

    public PriceRepository(){
        super();
    }

    @Override
    public List<Price> readAllObjects() {
        String query = String.format("SELECT e FROM Price e");
        return HibernateUtils.entityManager.createQuery(query).getResultList();
    }
}
