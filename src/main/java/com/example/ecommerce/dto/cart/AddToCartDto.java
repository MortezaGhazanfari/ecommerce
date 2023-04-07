package com.example.ecommerce.dto.cart;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class AddToCartDto {
    private Long id;

    private @NotNull Integer productId;
    private @NotNull Integer quantity;
}
