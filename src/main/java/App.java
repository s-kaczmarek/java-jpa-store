import entity.Price;
import entity.Product;
import entity.Sale;
import entity.commons.ProductCategory;
import utils.HibernateUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args){

        System.out.println(HibernateUtils.PI);

//        Sale sale = generateData();
//
//        HibernateUtils.persistObject(sale);
//
//        HibernateUtils.closeSession();
    }

    private static Sale generateData() {
        Product kaszanka = new Product();
        kaszanka.setCategory(ProductCategory.GROCERY);
        kaszanka.setIdentifier("kaszanka");
        kaszanka.setLabel("GRO_02");

        Price kaszankaPrice = new Price();
        kaszankaPrice.setBegin_date(LocalDate.now());
        kaszankaPrice.setPrice(800.0);
        HibernateUtils.persistObject(kaszankaPrice);

        List<Price> prices = new ArrayList<>();
        prices.add(kaszankaPrice);

        kaszanka.setPrices(prices);
        HibernateUtils.persistObject(kaszanka);


        /////////////////////////////////

        Product pepsi = new Product();
        pepsi.setCategory(ProductCategory.GROCERY);
        pepsi.setIdentifier("pizza");
        pepsi.setLabel("GRO_03");

        Price pepsiPrice = new Price();
        pepsiPrice.setBegin_date(LocalDate.now());
        pepsiPrice.setPrice(1400.0);
        HibernateUtils.persistObject(pepsiPrice);

        List<Price> pepsiPrices = new ArrayList<>();
        pepsiPrices.add(pepsiPrice);

        pepsi.setPrices(pepsiPrices);
        HibernateUtils.persistObject(pepsi);

        List<Product> products = new ArrayList<>();
        products.add(kaszanka);
        products.add(pepsi);

        Sale sale = new Sale();
        sale.setProducts(products);
        return sale;
    }
}
