package com.cardenas.orders_app.model.dto;

import lombok.Data;

@Data
public class AddProductToOrderDTO {
    private int orderId;
    private int productId;
    private int quantity;
}
