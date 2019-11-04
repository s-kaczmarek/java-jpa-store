package service.facade;

import entity.Price;
import entity.Sale;
import service.repository.SaleRepository;

import java.util.List;

public class SaleFacadeService {

    private static SaleFacadeService instance;
    private SaleRepository saleRepository;

    public static SaleFacadeService getInstance(){
        if(instance == null){
            instance = new SaleFacadeService();
        }
        return instance;
    }

    public SaleFacadeService() {
        this.saleRepository = SaleRepository.getInstance();
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
