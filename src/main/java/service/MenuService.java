package service;

import entity.Product;
import service.repository.ProductRepository;

import java.util.List;
import java.util.Scanner;

public class MenuService {

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

        Scanner sc = new Scanner(System.in);
        int userChoice = sc.nextInt();

        do{
            userChoice = sc.nextInt();
            switch(userChoice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }

        }while(userChoice >= 1 && userChoice <= 4);

    }

    public static void serveStuffChoice(){
        Scanner sc = new Scanner(System.in);
        int userChoice = sc.nextInt();

        do{
            userChoice = sc.nextInt();
            switch(userChoice){
                case 1:
                    MenuService.printAllProducts();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }

        }while(userChoice >= 1 && userChoice <= 4);

    }

    private static void printAllProducts(){
//        List<Product> products =
    }
}
