package com.example.ecommerce.dto.cart;

import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.entity.Product;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@NoArgsConstructor
@ToString
@Getter
@Setter
public class CartItemDto {
    private Long id;
    @NotNull
    private Integer quantity;
    @NotNull
    private Product product;

    public CartItemDto(Cart cart) {
        this.setId(cart.getId());
        this.setQuantity(cart.getQuantity());
        this.setProduct(cart.getProduct());
    }
}
