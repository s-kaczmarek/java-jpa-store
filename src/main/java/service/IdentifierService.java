package service;

import entity.commons.ProductCategory;

import java.util.Random;

public class IdentifierService {

    public static String generateIdentifier(ProductCategory productCategory) throws WrongRangeException{

        int number = RandomService.generateIntBetween(1,99);
        StringBuilder sb = new StringBuilder();
        sb.append(productCategory.getShortName());
        sb.append("_");
        if(number < 10){
            sb.append(0);
        }
        sb.append(number);
        return sb.toString();
    }
}
