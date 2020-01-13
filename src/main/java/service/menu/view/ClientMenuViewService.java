package service.menu.view;

import entity.Product;
import service.RandomService;
import service.menu.logic.ClientMenuLogicService;
import utils.ScannerUtils;

import java.util.List;
import java.util.Scanner;

public class ClientMenuViewService {

    public static void printClientMenu(){
        System.out.println("");
        System.out.println(MenuViewService.generateMenuHeader("Client Menu"));
        System.out.println("1. New Cart");
        System.out.println("2. Main menu");
    }

    public static void printCartChoice(){
        System.out.println("1. Add another product");
        System.out.println("2. Buy");
        System.out.println("3. Abort operation");
    }

    // TODO
//    public static void serveClientMenu(){
//        int wallet;
//        try{
//            wallet = RandomService.generateIntBetween(50,200);
//        }catch(Exception e){
//            // Jestli wystąpi wyjątek to przypisujemy na sztywno 100
//            wallet = 100;
//        }
//
//        Scanner sc = ScannerUtils.getScanner();
//        int userChoice = sc.nextInt();
//
//        do{
//            switch(userChoice){
//                case 1: // Add to cart
//                    ClientMenuLogicService.
//                    break;
//                case 2: // Remove from cart
//                    break;
//                case 3: // Buy products
//                    break;
//                case 4: // Exit
//                    break;
//            }
//        }while(userChoice >= 1 && userChoice <= 5);
//    }
}
