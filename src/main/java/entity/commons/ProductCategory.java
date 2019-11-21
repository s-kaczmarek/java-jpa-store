package entity.commons;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public enum ProductCategory {

    CHEMISTRY("CHE"),
    GROCERY("GRO"),
    ALCOHOL("ALC"),
    UNDEFINED("UDF");

    private String shortName;
    private static List<String> shortNames;

    public String getShortName() {
        return shortName;
    }

    /**
     * @param shortName
     * Konstruktor enuma ustawia skróconą nazwę w polu shortName
     */
    ProductCategory(String shortName){
        this.shortName = shortName;
    }

    public static List<String> getShortNames(){
        return shortNames;
    }

    static{
        shortNames = new ArrayList<>();
        EnumSet<ProductCategory> productCategories = EnumSet.allOf(ProductCategory.class);
        for(ProductCategory pc : productCategories){
            shortNames.add(pc.getShortName());
        }
    }
}
