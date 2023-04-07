package com.example.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @JsonIgnore
    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;


    private int quantity;

    public Cart(Product product, Integer quantity, User user) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.createdDate = new Date();
    }
}
