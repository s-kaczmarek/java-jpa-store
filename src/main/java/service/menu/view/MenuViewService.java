package service.menu.view;

import entity.Product;
import service.facade.ProductFacadeService;

import java.util.List;

public class MenuViewService {

    public static ProductFacadeService productFacadeService;

    static{
        productFacadeService = ProductFacadeService.getInstance();
    }

    public static String generateMenuHeader(String headerName){
        int headerLength = headerName.length();
        StringBuilder sb = new StringBuilder();
        sb.append(headerName);
        sb.append("\n");
        for(int i = 0; i < headerLength ; i++ ){
            sb.append("=");
        }
        return sb.toString();
    }

    public static void displayPreviousMenuChoice(){
        System.out.println("X. Previous Menu");
    }

    public static void displayAllProducts(){
        List<Product> products = productFacadeService.readAllProducts();
        for(int i = 0; i < products.size(); i++){
            System.out.println(i+1 + ". " + products.get(i));
        }
    }
}
