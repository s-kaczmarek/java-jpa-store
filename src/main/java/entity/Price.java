package entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="prices")
public class Price {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade=CascadeType.ALL)
    private Product product;

    private Double price;
    private LocalDate beginDate;
    private LocalDate endDate;

    public static final class Builder {

        private Double price;
        private LocalDate beginDate;
//        private LocalDate endDate;

        public Builder price(Double price){
            this.price = price;
            return this;
        }

//        public Builder endDate(LocalDate end_date){
//            this.endDate = end_date;
//            return  this;
//        }

        public Price build(){
            Price price = new Price();
            price.setPrice(this.price);
            price.setBeginDate(LocalDate.now());
//            price.setEndDate(this.endDate);

            return price;
        }

    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Price{" +
                "price= " + price +
                " beginDate= " + beginDate +
                " endDate= " + endDate +
                '}';
    }
}
