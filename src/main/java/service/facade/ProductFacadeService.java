package service.facade;

import entity.Product;
import service.repository.ProductRepository;

import java.util.List;

/**
 * This is singleton class responsible for ...
 */

public class ProductFacadeService {

    // pole przechowujące instancję singletonowej klasy. Jest przywatne, ponieważ dostęp ma być tylko poprzez getInstance.
    // Statyczne, ponieważ potrzebujemy jednej instancji, więc jest to składnik klasy a nie obiektu.
    private static ProductFacadeService instance;

    // pole przechowujące obiekt repozytorium
    private ProductRepository productRepository;

    // metoda, której zadanie polega na utworzeniu nowej instancji w przypadku kiedy pole instance jest puste i zwrócenie referencji.
    public static ProductFacadeService getInstance(){
        if(instance == null){
            instance = new ProductFacadeService();
        }
        return instance;
    }

    // konstruktor przypisuje do pola instance obiekt utworzony przez metodę getinstance
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
