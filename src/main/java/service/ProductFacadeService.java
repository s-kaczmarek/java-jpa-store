package service;

import entity.Product;
import service.repository.ProductRepository;

import java.util.List;

public class ProductFacadeService {

    private ProductRepository productRepository;

    public ProductFacadeService() {
        this.productRepository = new ProductRepository();
    }

    public void persistObject(Product product){
        this.productRepository.persistObject(product);
    }

    public List readAllObjects(){
        this.productRepository.readAllObjects();
        // TODO
    }

    public Object readObjectById(T id){

    }

    public void updateObject(Object object){

    }

    public void deleteObject(Object object){

    }


}
