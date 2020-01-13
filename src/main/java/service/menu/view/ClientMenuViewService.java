package service.menu.view;

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
}
