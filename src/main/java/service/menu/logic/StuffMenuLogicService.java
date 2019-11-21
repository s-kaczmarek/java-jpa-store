package service.menu.logic;

import entity.Product;
import entity.commons.ProductCategory;
import entity.commons.ProductStatus;
import entity.dto.ProductDTO;
import service.exception.ProductNotCompleteException;
import service.exception.WrongRangeException;
import service.menu.view.MenuViewService;
import service.menu.view.StuffMenuViewService;
import service.repository.ProductRepository;
import utils.ScannerUtils;

import java.util.List;
import java.util.Scanner;

public class StuffMenuLogicService {

    public static void serveStuffChoice(){
        Scanner sc = ScannerUtils.getScanner();
        int userChoice = 0;

        boolean isInsideStuffMenu = true;
        do{
            StuffMenuViewService.printStuffMenu();
            if(sc.hasNext()) {
                userChoice = sc.nextInt();
            }
            switch(userChoice){
                case 1:
                    displayAllProducts();
                    break;
                case 2:
                    try{
                        addNewProduct();
                    }catch(WrongRangeException | ProductNotCompleteException e){
                        System.out.println("Unable to add product due to error: " + e.getMessage());
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    isInsideStuffMenu = false;
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

    private static void addNewProduct() throws WrongRangeException, ProductNotCompleteException {

        ProductRepository productRepository = ProductRepository.getInstance();

        String label;
        Double price;
        ProductStatus status = ProductStatus.UNDEFINED;
        ProductCategory category = ProductCategory.UNDEFINED;

        Scanner sc = ScannerUtils.getScanner();
        ProductDTO productDTO = new ProductDTO();

        System.out.print("Enter name/label: ");
        label = sc.next();
        System.out.print("Enter price: ");
        price = sc.nextDouble();

        // Product Status
        boolean isUserChoiceIncorrect = false;
        String userChoice;
        do{
            isUserChoiceIncorrect = false;
            System.out.println("Choose status: ");
            System.out.println("1. Active");
            System.out.println("2. Pending");
            System.out.println("X. Exit");
            userChoice = sc.next();
            if(userChoice.equals("1")){
                status = ProductStatus.ACTIVE;
            }else if(userChoice.equals("2")) {
                status = ProductStatus.PENDING;
            }else if(userChoice.equalsIgnoreCase("x")){
                return;
            }else{
                System.out.println("Wrong input!");
                isUserChoiceIncorrect = true;
            }
        }while(isUserChoiceIncorrect);

        // Product Category
        boolean isUserChoiceIncorrect2 = false;
        String userChoice2;
        do{
            isUserChoiceIncorrect2 = false;
            System.out.println("Choose product category: ");
            System.out.println("1. Chemistry");
            System.out.println("2. Grocery");
            System.out.println("3. Alcohol");
            System.out.println("X. Exit");
            userChoice2 = sc.next();
            if(userChoice2.equals("1")){
                category = ProductCategory.CHEMISTRY;
            }else if(userChoice2.equals("2")) {
                category = ProductCategory.GROCERY;
            }else if(userChoice2.equals("3")) {
                category = ProductCategory.ALCOHOL;
            }else if(userChoice2.equalsIgnoreCase("x")){
                return;
            }else{
                System.out.println("Wrong input!");
                isUserChoiceIncorrect2 = true;
            }
        }while(isUserChoiceIncorrect2);

        System.out.println("New product: ");
        System.out.println(label);
        System.out.println(price);
        System.out.println(status);
        System.out.println(category);
        System.out.println("");
        System.out.println("Correct? (y/n)");

        String userChoice3 = sc.next();

        if(userChoice3.equalsIgnoreCase("y")){
            productDTO = new ProductDTO.Builder()
                    .label(label)
                    .price(price)
                    .status(status)
                    .category(category)
                    .build();
            Product product = Product.mapFromDTO(productDTO);
            productRepository.persistObject(product);
            System.out.println("New product added!");
        }else{
            System.out.println("New product rejected by user!");
        }
    }
}
