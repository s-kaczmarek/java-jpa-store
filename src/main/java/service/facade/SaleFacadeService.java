package service.facade;

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

    public void persistObject(Sale sale){
        this.saleRepository.persistObject(sale);
    }

    public List<Sale> readAllSales(){
        return this.saleRepository.readAllSales();
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
