package service.facade;

import entity.Price;
import service.repository.PriceRepository;

import java.util.List;

public class PriceFacadeService {

    private static PriceFacadeService instance;
    private PriceRepository priceRepository;

    public static PriceFacadeService getInstance(){
        if(instance == null){
            instance = new PriceFacadeService();
        }
        return instance;
    }

    public PriceFacadeService() {
        this.priceRepository = PriceRepository.getInstance();
    }

    public void persistObject(Price price){
        this.priceRepository.persistObject(price);
    }

    public List<Price> readAllObjects(){
        return this.priceRepository.readAllObjects();
    }

    public Price readObjectById(Long id){
        return (Price) this.priceRepository.readObjectById(id);
    }

    public void updateObject(Price price){
        this.priceRepository.updateObject(price);
    }

    public void deleteObject(Price price){
        this.priceRepository.deleteObject(price);
    }
}
