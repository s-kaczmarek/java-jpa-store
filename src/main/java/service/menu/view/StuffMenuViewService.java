package service.menu.view;

public class StuffMenuViewService {

    public static void printStuffMenu(){
        System.out.println("");
        System.out.println(MenuViewService.generateMenuHeader("Stuff Menu"));
        System.out.println("1. Display all products");
        System.out.println("2. Add new product");
        System.out.println("3. Assign price to product");
        System.out.println("4. Delete product");
        System.out.println("5. Main menu");
    }
}
