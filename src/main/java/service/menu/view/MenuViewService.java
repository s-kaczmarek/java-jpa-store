package service.menu.view;

import service.facade.ProductFacadeService;

public class MenuViewService {

    public static ProductFacadeService productFacadeService;

    static{
        productFacadeService = ProductFacadeService.getInstance();
    }

    public static String generateMenuHeader(String headerName){
        int headerLength = headerName.length();
        StringBuilder sb = new StringBuilder();
        sb.append(headerName);
        sb.append("\n");
        for(int i = 0; i < headerLength ; i++ ){
            sb.append("=");
        }
        return sb.toString();
    }

    public static void displayPreviousMenuChoice(){
        System.out.println("X. Previous Menu");
    }
}
