package com.example.ecommerce.entity;

import com.example.ecommerce.dto.product.ProductDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private @NotNull String name;
    private @NotNull String imageURL;
    private @NotNull double price;
    private @NotNull String description;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    Category category;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<WishList> wishListList;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Cart> carts;

    public Product(ProductDto productDto, Category category) {
        this.name = productDto.getName();
        this.imageURL = productDto.getImageURL();
        this.description = productDto.getDescription();
        this.price = productDto.getPrice();
        this.category = category;
    }

    public Product(String name, String imageURL, double price, String description, Category category) {
        super();
        this.name = name;
        this.imageURL = imageURL;
        this.price = price;
        this.description = description;
        this.category = category;
    }
}
