package com.cardenas.orders_app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductFromOrderDTO {
    private int orderItemId;
    private int orderId;
    private String productName;
    private int quantity;
    private double totalPrice;
}
