package service.menu.view;

public class StuffMenuViewService {

    public static void printStuffMenu(){
        System.out.println("");
        System.out.println(MenuViewService.generateMenuHeader("Stuff Menu"));
        System.out.println("1. Display all products");
        System.out.println("2. Display all sales");
        System.out.println("3. Add new product");
        System.out.println("4. Change price of product");
        System.out.println("5. Delete product");
        System.out.println("6. Main menu");
    }
}
