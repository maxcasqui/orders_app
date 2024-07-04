package com.cardenas.orders_app.entity.dto;

import lombok.Data;

@Data
public class AddProductToOrderDTO {
    private int orderId;
    private int productId;
    private int quantity;
}
