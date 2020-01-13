package entity.dto;

import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class CartDTO {

    private List<Product> products;

    public CartDTO(){
        this.products = new ArrayList<Product>();
    }

    public void attachProduct(Product product, int quantity){
        for(int i = 0; i < quantity; i++){
            this.products.add(product);
        }
    }

    public void removeAllProducts(){
        this.products.clear();
    }

    public List<Product> getProducts(){
        return products;
    }

    public double sumOfAllProductsValue(){
        double sum = 0;
        List<Product> products = getProducts();
        for(Product p : products){
            int indexOfLastPrice = p.getPrices().size() - 1;
            sum += p.getPrices().get(indexOfLastPrice).getPrice();
        }
        return sum;
    }
}
