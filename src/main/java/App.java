import service.MenuService;

import java.util.Scanner;

public class App {

    public static void main(String[] args){

        boolean run = true;
        Scanner sc = new Scanner(System.in);
        do {
            MenuService.printMainMenu();

            int userChoice = sc.nextInt();
            switch(userChoice){
                case 1:
                    MenuService.printClientMenu();
                    MenuService.serveClientChoice();
                case 2:
                    MenuService.printStuffMenu();
                    MenuService.serveStuffChoice();
                case 3:
                    run = false;
                default:
                    throw new IllegalArgumentException("Unexpected value: " + userChoice);
            }


        }while(run);
        sc.close();
    }
}
