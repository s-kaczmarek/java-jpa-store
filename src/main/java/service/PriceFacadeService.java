package service;

import entity.Price;
import service.repository.PriceRepository;

import java.util.List;

public class PriceFacadeService {

    private PriceRepository priceRepository;

    public PriceFacadeService() {
        this.priceRepository = new PriceRepository();
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
