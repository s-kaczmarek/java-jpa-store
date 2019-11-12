package service.menu.view;

public class MainMenuViewService {

    public static void printMainMenu(){
        System.out.println(MenuViewService.generateMenuHeader("Menu"));
        System.out.println("Choose mode: ");
        System.out.println("1. Client");
        System.out.println("2. Stuff");
        System.out.println("3. Exit");
    }
}
