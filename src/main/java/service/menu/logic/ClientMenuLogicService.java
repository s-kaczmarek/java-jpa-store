package service.menu.logic;

import entity.dto.CartDTO;
import entity.Product;
import entity.Sale;
import service.RandomService;
import service.enums.CartChoice;
import service.exception.WrongRangeException;
import service.facade.ProductFacadeService;
import service.facade.SaleFacadeService;
import service.menu.view.ClientMenuViewService;
import service.menu.view.MenuViewService;
import utils.ScannerUtils;

import java.util.List;
import java.util.Scanner;

public class ClientMenuLogicService {

    public static double wallet;
    public static ProductFacadeService productFacadeService;
    public static SaleFacadeService saleFacadeService;
    public static CartDTO cartDTO;

    static{
        productFacadeService = ProductFacadeService.getInstance();
        saleFacadeService = SaleFacadeService.getInstance();
    }

    public static void serveClientChoice() throws WrongRangeException {
        Scanner sc = ScannerUtils.getScanner();
        int userChoice = 0;

        cartDTO = new CartDTO();
        wallet = generateWalletValue();

        boolean isInsideClientMenu = true;
        do{
            ClientMenuViewService.printClientMenu();
            if(sc.hasNext()) {
                userChoice = sc.nextInt();
                sc.nextLine();
            }
            switch(userChoice){
                case 1: // add to cart
                    CartChoice userCartChoice = CartChoice.ADD_ANOTHER_PRODUCT;
                    do{
                        cartDTO = addProductToCart(cartDTO);
                        System.out.println("tu 1");
                        try{
                            userCartChoice = serveCartChoice();
                            System.out.println("tu 2");
                            if(userCartChoice.equals(CartChoice.BUY)){
                                buy(cartDTO);
                                cartDTO.removeAllProducts();
                            } else if(userCartChoice.equals(CartChoice.ABORT_OPERATION)){
                                System.out.println("Sale aborted, cart will be cleaned");
                                cartDTO.removeAllProducts();
                                break;
                            }
                        }catch(WrongRangeException e){
                            System.out.println("Wrong choice, try again");
                        }
//                  TODO - dodac zatwierdzenie sale.
                    } while(userCartChoice.equals(CartChoice.ADD_ANOTHER_PRODUCT));
                    break;
                case 2: // exit
                    isInsideClientMenu = false;
                    break;
            }
        }while(isInsideClientMenu);
    }

    private static CartChoice serveCartChoice() throws WrongRangeException {
        Scanner sc = ScannerUtils.getScanner();
        ClientMenuViewService.printCartChoice();
        System.out.println("Jesteśmy przed ");
        int userChoice = sc.nextInt();
        sc.nextLine();
//        String aaa = sc.nextLine();
//        int userChoice = Integer.parseInt(aaa);
        System.out.println("Jesteśmy po!");
        switch(userChoice){
            case 1: return CartChoice.ADD_ANOTHER_PRODUCT;
            case 2: return CartChoice.BUY;
            case 3: return CartChoice.ABORT_OPERATION;
            default: throw new WrongRangeException("Wrong user choice!");
        }
    }

    private static void buy(CartDTO cartDTO){
        List<Product> productsToBuy = cartDTO.getProducts();
        System.out.println("Products in cart:");
        productsToBuy.forEach(p -> System.out.println(p));

        if(cartDTO.sumOfAllProductsValue() <= wallet){
            Sale sale = Sale.mapFromDTO(cartDTO);
            saleFacadeService.persistObject(sale);
            System.out.println("Sale persisted!");
        }else{
            System.out.println("You don't have enought money!!!");
        }
    }

    private static CartDTO addProductToCart(CartDTO cartDTO) throws WrongRangeException {
        Scanner sc = ScannerUtils.getScanner();
        List<Product> products = productFacadeService.readAllProducts();
        MenuViewService.displayAllProducts();

        double currentCartValue = ClientMenuLogicService.cartDTO.sumOfAllProductsValue();
        System.out.println("\nWallet: " + ClientMenuLogicService.wallet + "$. Cart Value: "
                + currentCartValue + "$. Available money: "
                + (ClientMenuLogicService.wallet - currentCartValue) + "$\n");
        System.out.println("Choose product index: ");

        int chosenIndex = sc.nextInt();
        sc.nextLine();

        if(chosenIndex <= products.size()){
            Product chosenProduct = products.get(chosenIndex - 1);
            System.out.println("Quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();
            cartDTO.attachProduct(chosenProduct, quantity);
        }else{
            System.out.println("test");
            throw new WrongRangeException("Chosen index is out of range");
        }

        return cartDTO;
    }

    public static int generateWalletValue(){
        int wallet;
        try{
            wallet = RandomService.generateIntBetween(50,200);
        }catch(Exception e){
            // Jestli wystąpi wyjątek to przypisujemy na sztywno 100
            wallet = 100;
        }
        return wallet;
    }
}
