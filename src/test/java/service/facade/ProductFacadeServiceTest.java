package service.facade;

import entity.Product;
import org.junit.Test;

import java.util.List;

public class ProductFacadeServiceTest {

    @Test
    public void shouldGetAllProductsTest(){
        ProductFacadeService pf = ProductFacadeService.getInstance();

        List<Product> products = pf.readAllProducts();


    }
}
