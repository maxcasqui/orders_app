package com.cardenas.orders_app.model.dto;

import java.security.Timestamp;
import lombok.Data;

@Data
public class OrderDTO {
    private String orderNumber;
    private Timestamp orderDate;
}
