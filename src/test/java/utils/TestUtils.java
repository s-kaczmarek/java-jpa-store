package utils;

import entity.Price;
import entity.Product;
import entity.Sale;
import entity.commons.ProductCategory;
import entity.commons.ProductStatus;
import service.exception.WrongRangeException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *  This class generates test objects
 */
public class TestUtils {

    private static Random r;

    static{
        r = new Random();
    }

    public static Price generatePrice(){
        return new Price.Builder()
                .price(10 + r.nextDouble() % 90) // 10 + ...  % 90 zwróci resztę z dzielenia przez 90, czyli liczby z przedziały 10 - 99,999999
             // .beginDate(LocalDate.of(2019,1 + r.nextInt() % 12, 1 + r.nextInt() % 28))
                .beginDate(LocalDate.now().minusDays(1 + r.nextInt() % 365))
                .build();
    }

    public static Product generateProduct() throws WrongRangeException {
        List<Price> prices = Arrays.asList(
                generatePrice(),
                generatePrice(),
                generatePrice()
        );

        return new Product.Builder()
                .category(ProductCategory.GROCERY)
                .label("Coca-Cola")
                .launchDate(LocalDate.of(2019,8,8))
                .prices(prices)
                .status(ProductStatus.ACTIVE)
                .build();
    }

    public static Sale generateSale() throws WrongRangeException {
        List<Product> products = Arrays.asList(
                generateProduct(),
                generateProduct(),
                generateProduct()
        );

        return new Sale.Builder()
                .salesTime(LocalDateTime.of(2018,5,11,12,34,12))
                .products(products)
                .build();
    }
}
