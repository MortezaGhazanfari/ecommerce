package com.example.ecommerce.dto.order;


import com.example.ecommerce.entity.Order;
import jakarta.validation.constraints.NotNull;

public class OrderDto {
    private Long id;
    private @NotNull Long userId;

    public OrderDto() {
    }

    public OrderDto(Order order) {
        this.setId(order.getId());
        //this.setUserId(order.getUserId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
