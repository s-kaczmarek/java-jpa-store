package service;

import entity.Product;
import service.repository.ProductRepository;

import java.util.List;

public class ProductFacadeService {

    private static ProductFacadeService instance;

    public static ProductFacadeService getInstance(){
        if(instance == null){
            instance = new ProductFacadeService();
        }
        return instance;
    }

    private ProductRepository productRepository;

    public ProductFacadeService() {
        this.productRepository = ProductRepository.getInstance();
    }

    public void persistObject(Product product){
        this.productRepository.persistObject(product);
    }

    public List<Product> readAllProducts(){
        return this.productRepository.readAllObjects();
    }

    public Product readObjectById(Long id){
        return (Product) this.productRepository.readObjectById(id);
    }

    public void updateObject(Product product){
        this.productRepository.updateObject(product);
    }

    public void deleteObject(Product product){
        this.productRepository.deleteObject(product);
    }
}
