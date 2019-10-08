package entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="sales")
public class Sale {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime salesTime;

    @ManyToMany//(mappedBy="sales") // Jeden rachunek może zawierać wiele produktów, a jeden produkt, może występowac na wielu rachunkach // Jeden rachunek może zawierać wiele produktów, a jeden produkt, może występowac na wielu rachunkach
    private List<Product> products;

    public static final class Builder {

        private LocalDateTime salesTime;
        private List<Product> products;

        public Builder salesTime(LocalDateTime salesTime){
            this.salesTime = salesTime;
            return this;
        }

        public Builder products(List<Product> products){
            this.products = products;
            return this;
        }

        public Sale build(){
            Sale sale = new Sale();
            sale.setSalesTime(this.salesTime);
            sale.setProducts(this.products);

            return sale;
        }
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getSalesTime() {
        return salesTime;
    }

    public void setSalesTime(LocalDateTime salesTime) {
        this.salesTime = salesTime;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
