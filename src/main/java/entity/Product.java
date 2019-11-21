package entity;

import com.sun.istack.NotNull;
import entity.commons.ProductCategory;
import entity.commons.ProductStatus;
import entity.dto.ProductDTO;
import service.IdentifierService;
import service.exception.ProductNotCompleteException;
import service.exception.WrongRangeException;
import service.repository.PriceRepository;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String identifier;
    private String label;
    private LocalDate launchDate;
    private LocalDate withdrawalDate;

    @OneToMany
    private List<Price> prices;

    @ManyToMany
    private List<Sale> sales;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @Enumerated(EnumType.STRING)
	private ProductCategory category;

    public static final class Builder {

        private String label;
        private LocalDate launchDate;
        private LocalDate withdrawalDate;
        private List<Price> prices;
        private List<Sale> sales;
        private ProductStatus status;
        private ProductCategory category;

        public Builder label(String label){
            this.label = label;
            return this;
        }

        public Builder launchDate(LocalDate launchDate){
            this.launchDate = launchDate;
            return this;
        }

        public Builder withdrawalDate(LocalDate withdrawalDate){
            this.withdrawalDate = withdrawalDate;
            return this;
        }

        public Builder prices(List<Price> prices){
            this.prices = prices;
            return this;
        }

        public Builder sales(List<Sale> sales){
            this.sales = sales;
            return this;
        }

        public Builder status(ProductStatus status){
            this.status = status;
            return this;
        }

        public Builder category(ProductCategory category){
            this.category = category;
            return this;
        }

        public Product build() throws WrongRangeException {
            Product product = new Product();
            product.setIdentifier(IdentifierService.generateIdentifier(this.category));
            product.setLabel(this.label);
            if(this.status.equals(ProductStatus.ACTIVE)){
                product.setLaunchDate(LocalDate.now());
            }else{
                product.setLaunchDate(this.launchDate);
            }
            product.setWithdrawalDate(this.withdrawalDate);
            product.setPrices(this.prices);
            product.setSales(this.sales);
            product.setStatus(this.status);
            product.setCategory(this.category);

            return product;
        }
    }

    public static Product mapFromDTO(ProductDTO productDTO) throws WrongRangeException, ProductNotCompleteException {
        PriceRepository priceRepository = PriceRepository.getInstance();
        if(productDTO.isNotValid()){
            throw new ProductNotCompleteException("One or more of the fields is empty!");
        }
        Price price = new Price();
        price.setPrice(productDTO.getPrice());
        priceRepository.persistObject(price);
        List<Price> prices = new ArrayList<>();
        prices.add(price);

        Product product = new Builder()
                .label(productDTO.getLabel())
                .prices(prices)
                .status(productDTO.getStatus())
                .category(productDTO.getCategory())
                .build();

        return product;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", identifier='" + identifier + '\'' +
                ", label='" + label + '\'' +
                ", launchDate=" + launchDate +
                ", withdrawalDate=" + withdrawalDate +
                ", prices=" + prices +
                ", sales=" + sales +
                ", status=" + status +
                ", category=" + category +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public LocalDate getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(LocalDate launchDate) {
        this.launchDate = launchDate;
    }

    public LocalDate getWithdrawalDate() {
        return withdrawalDate;
    }

    public void setWithdrawalDate(LocalDate withdrawalDate) {
        this.withdrawalDate = withdrawalDate;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }
}
