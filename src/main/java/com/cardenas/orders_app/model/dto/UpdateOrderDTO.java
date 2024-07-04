package com.cardenas.orders_app.model.dto;

import lombok.Data;

@Data
public class UpdateOrderDTO {
    private int orderId;
    private String status;
}
