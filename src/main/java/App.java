import service.exception.WrongRangeException;
import service.menu.logic.ClientMenuLogicService;
import service.menu.logic.StuffMenuLogicService;
import service.menu.view.ClientMenuViewService;
import service.menu.view.MainMenuViewService;
import utils.ScannerUtils;

import java.util.Scanner;

public class App {

    public static void main(String[] args){

        boolean isProgramRunning = true;
        Scanner sc = ScannerUtils.getScanner();
        do {
            MainMenuViewService.printMainMenu();

            int userChoice = sc.nextInt();

            switch(userChoice){
                case 1:
                    try{
                        ClientMenuLogicService.serveClientChoice();
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    StuffMenuLogicService.serveStuffChoice();
                    break;
                case 3:
                    isProgramRunning = false;
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected value: " + userChoice);
            }
        }while(isProgramRunning);
    }
}
