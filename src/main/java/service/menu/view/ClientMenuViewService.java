package service.menu.view;

import entity.Product;
import service.RandomService;
import utils.ScannerUtils;

import java.util.List;
import java.util.Scanner;

public class ClientMenuViewService {

    public static void printClientMenu(){
        System.out.println("");
        System.out.println(MenuViewService.generateMenuHeader("Client Menu"));
        System.out.println("1. Add to Cart");
        System.out.println("2. Remove from Cart");
        System.out.println("3. Buy Products");
        System.out.println("4. Exit");
    }

    // TODO
    public static void serveClientChoice(){
        int wallet;
        try{
            wallet = RandomService.generateIntBetween(50,200);
        }catch(Exception e){
            // Jestli wystąpi wyjątek to przypisujemy na sztywno 100
            wallet = 100;
        }

        Scanner sc = ScannerUtils.getScanner();
        int userChoice = sc.nextInt();

        do{
            switch(userChoice){
                case 1: // View all products
                    List<Product> products = MenuViewService.productFacadeService.readAllProducts();
                    for(int i = 0; i < products.size(); i++){
                        System.out.println(i + ". " + products.get(i));
                    }
                    break;
                case 2: // Add new product
                    break;
                case 3: // Assign price to product
                    break;
                case 4: // Delete product
                    break;
                case 5: // Exit
                    break;
            }
        }while(userChoice >= 1 && userChoice <= 5);
    }
}
