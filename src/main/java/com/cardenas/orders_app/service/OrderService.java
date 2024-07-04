package com.cardenas.orders_app.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cardenas.orders_app.entity.Order;
import com.cardenas.orders_app.entity.dto.AddProductToOrderDTO;
import com.cardenas.orders_app.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Object[]> listOrders() {
        return orderRepository.listOrders();
    }

    public void deleteOrder(int orderId) {
        orderRepository.deleteOrder(orderId);
    }

    public void addProductToOrder(AddProductToOrderDTO orderItem) {
        orderRepository.addProductToOrder(orderItem.getOrderId(), orderItem.getProductId(), orderItem.getQuantity());
    }

    public void addOrder(String orderNumber, LocalDateTime orderDate, String status) {
        Order order = new Order();
        order.setOrderNumber(orderNumber);
        order.setOrderDate(orderDate);
        order.setStatus(status);
        orderRepository.save(order);
    }
}
