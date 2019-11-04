package service.repository;

import entity.Sale;

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
}
