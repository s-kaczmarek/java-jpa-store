package service.menu.logic;

import entity.Product;
import service.menu.view.MenuViewService;
import utils.ScannerUtils;

import java.util.List;
import java.util.Scanner;

public class StuffMenuLogicService {

    public static void serveStuffChoice(){
        Scanner sc = ScannerUtils.getScanner();
        int userChoice = 0;
        if(sc.hasNext()) {
            userChoice = sc.nextInt();
        }

        boolean isInsideStuffMenu = true;
        do{
            switch(userChoice){
                case 1:
                    displayAllProducts();
                    break;
                case 2:
                    addNewProduct();
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        }while(isInsideStuffMenu);
    }

    public static void displayAllProducts() {
        Scanner sc = ScannerUtils.getScanner();
        List<Product> products = MenuViewService.productFacadeService.readAllProducts();
        for(int i = 0; i < products.size(); i++){
            System.out.println(i + ". " + products.get(i));
        }
        MenuViewService.displayPreviousMenuChoice();
        boolean isUserChoiceIncorrect = true;
        String userChoice;
        do{
            userChoice = sc.nextLine();
            if(userChoice.equals("X")){
                isUserChoiceIncorrect = false;
            }
        }while(isUserChoiceIncorrect);
    }

    private static void addNewProduct() {
        Scanner sc = ScannerUtils.getScanner();
        Product product = new Product(); // zamiast tego DTO
        // Product{id=1, identifier='pizda', label='GR01', launchDate=null, withdrawalDate=null,
        // prices=[entity.Price@5a6d30e2], sales=[], status=null, category=GROCERY}

        System.out.println("question 1");
    }

}
