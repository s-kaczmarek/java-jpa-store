package entity.dto;

import entity.Product;
import entity.commons.ProductCategory;
import entity.commons.ProductStatus;

public class ProductDTO extends Product {

    private String label;
    private Double price;
    private ProductStatus status;
    private ProductCategory category;

    public static final class Builder {

        private String label;
        private Double price;
        private ProductStatus status;
        private ProductCategory category;

        public Builder label(String label){
            this.label = label;
            return this;
        }

        public Builder price(Double price){
            this.price = price;
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

        public ProductDTO build(){
            ProductDTO productDTO = new ProductDTO();
            productDTO.setLabel(this.label);
            productDTO.setPrice(this.price);
            productDTO.setStatus(this.status);
            productDTO.setCategory(this.category);

            return productDTO;
        }
    }

    public boolean isNotValid(){
        return  this.label      == null ||
                this.price      == null ||
                this.status     == null ||
                this.category   == null;
    }

    public ProductDTO() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
