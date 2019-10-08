package entity.commons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

public enum ProductCategory {

    CHEMISTRY("CHE"),
    GROCERY("GRO"),
    ALCOHOL("ALC");

    private String shortName;
    private static List<String> shortNames;

    public String getShortName() {
        return shortName;
    }

    ProductCategory(String shortName){
        this.shortName = shortName;
        System.out.println("#### " + this.shortName);
    }

    public static List<String> getShortNames(){
        return shortNames;
    }

    static{
        shortNames = new ArrayList<>();
        System.out.println("jestem w staticu");
        EnumSet<ProductCategory> productCategories = EnumSet.allOf(ProductCategory.class);
        for(ProductCategory pc : productCategories){
            shortNames.add(pc.getShortName());
        }
    }
}
