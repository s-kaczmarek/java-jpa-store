package service.repository;

import entity.Price;

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
}
