package service.menu.view;

import entity.Product;
import entity.Sale;
import service.facade.ProductFacadeService;
import service.facade.SaleFacadeService;

import java.util.List;

public class MenuViewService {

    public static ProductFacadeService productFacadeService;
    public static SaleFacadeService saleFacadeService;

    static{
        productFacadeService = ProductFacadeService.getInstance();
        saleFacadeService = SaleFacadeService.getInstance();
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

    public static void displayAllSales() {
        List<Sale> sales = saleFacadeService.readAllSales();
        for(int i = 0; i < sales.size(); i++){
            System.out.println(i+1 + ". " + sales.get(i));
        }
    }
}
