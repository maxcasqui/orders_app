package com.cardenas.orders_app.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cardenas.orders_app.model.dto.AddProductToOrderDTO;
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

    public void addOrder(String orderNumber, String orderDate) {
        LocalDate date = LocalDate.parse(orderDate);
        orderRepository.addOrder(orderNumber, date);
    }

    public void deleteItemFromOrder(int itemId){
        orderRepository.deleteItemFromOrder(itemId);
    }

    public void updateOrderStatus(int orderId, String status){
        orderRepository.updateOrderStatus(orderId, status);
    }
}
