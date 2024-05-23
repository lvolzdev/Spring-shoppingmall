package com.example.demo.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private int id;

    @JsonProperty("product_name")
    @NotBlank(message = "상품명은 필수 입력 값입니다.")
    private String name;

    @JsonProperty("product_price")
    @NotBlank(message = "상품 가격은 필수 입력 값입니다.")
    private int price;

    @JsonProperty("product_description")
    private String description;

    @JsonProperty("product_categoryId")
    @NotBlank(message = "카테고리 id는 필수 입력 값입니다.")
    private int categoryId;

    public Product convertToEntity() {
        return new Product(name, price, description, categoryId);
    }

    public ProductDTO convertToDTO(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.categoryId = product.getCategoryId();
        return this;
    }

    public ProductDTO(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.categoryId = product.getCategoryId();
    }
}
