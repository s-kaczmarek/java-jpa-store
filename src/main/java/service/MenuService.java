package service;

import entity.Product;
import service.facade.ProductFacadeService;

import java.util.List;
import java.util.Scanner;

public class MenuService {

    private static ProductFacadeService productFacadeService;

    static{
        productFacadeService = ProductFacadeService.getInstance();
    }

    private static String generateMenuHeader(String headerName){
        int headerLength = headerName.length();
        StringBuilder sb = new StringBuilder();
        sb.append(headerName);
        sb.append("\n");
        for(int i = 0; i < headerLength ; i++ ){
            sb.append("=");
        }
        return sb.toString();
    }

    public static void printMainMenu(){
        System.out.println(generateMenuHeader("Menu"));
        System.out.println("Choose mode: ");
        System.out.println("1. Client");
        System.out.println("2. Stuff");
    }

    public static void printClientMenu(){
        System.out.println("");
        System.out.println(generateMenuHeader("Client Menu"));
        System.out.println("1. Add to Cart");
        System.out.println("2. Remove from Cart");
        System.out.println("3. Buy Products");
        System.out.println("4. Exit");
    }

    public static void printStuffMenu(){
        System.out.println("");
        System.out.println(generateMenuHeader("Stuff Menu"));
        System.out.println("1. View all products");
        System.out.println("2. Add new product");
        System.out.println("3. Assign price to product");
        System.out.println("4. Delete product");
        System.out.println("5. Exit");
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

        Scanner sc = new Scanner(System.in);
        int userChoice = sc.nextInt();

        do{
            userChoice = sc.nextInt();
            switch(userChoice){
                case 1: // View all products
                    List<Product> products = productFacadeService.readAllProducts();
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
            sc.close();
        }while(userChoice >= 1 && userChoice <= 5);
    }

    public static void serveStuffChoice(){
        Scanner sc = new Scanner(System.in);
        int userChoice = sc.nextInt();

        do{
            userChoice = sc.nextInt();
            switch(userChoice){
                // TODO nie działa
                case 1: // View all products
                    List<Product> products = productFacadeService.readAllProducts();
                    for(int i = 0; i < products.size(); i++){
                        System.out.println(i + ". " + products.get(i));
                    }
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
            sc.close();
        }while(userChoice >= 1 && userChoice <= 4);

    }

    private static void printAllProducts(){
//        List<Product> products =
    }
}
