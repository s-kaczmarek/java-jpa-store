package service;

import entity.Price;
import entity.Sale;
import service.repository.SaleRepository;

import java.util.List;

public class SaleFacadeService {

    private SaleRepository saleRepository;

    public SaleFacadeService() {
        this.saleRepository = new SaleRepository();
    }

    public void persistObject(Price price){
        this.saleRepository.persistObject(price);
    }

    public List<Sale> readAllObjects(){
        return this.saleRepository.readAllObjects();
    }

    public Sale readObjectById(Long id){
        return (Sale) this.saleRepository.readObjectById(id);
    }

    public void updateObject(Sale sale){
        this.saleRepository.updateObject(sale);
    }

    public void deleteObject(Sale sale){
        this.saleRepository.deleteObject(sale);
    }
}
