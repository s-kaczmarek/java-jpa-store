package entity;

import entity.dto.CartDTO;

import javax.persistence.*;
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

    public static Sale mapFromDTO(CartDTO cartDTO) {
        return new Builder()
                .products(cartDTO.getProducts())
                .build();
    }

    public static final class Builder {

        private List<Product> products;

        public Builder products(List<Product> products){
            this.products = products;
            return this;
        }

        public Sale build(){
            Sale sale = new Sale();
            sale.setSalesTime(LocalDateTime.now());
            sale.setProducts(this.products);

            return sale;
        }
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", salesTime=" + salesTime +
                ", products=" + products +
                '}';
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
