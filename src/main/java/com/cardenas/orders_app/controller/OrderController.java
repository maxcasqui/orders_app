package com.cardenas.orders_app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cardenas.orders_app.model.dto.AddProductToOrderDTO;
import com.cardenas.orders_app.model.dto.OrderDTO;
import com.cardenas.orders_app.model.dto.UpdateOrderDTO;
import com.cardenas.orders_app.service.OrderService;

@RestController
@RequestMapping(path = "api/v1/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/list")
    public List<Object[]> listOrders() {
        return orderService.listOrders();
    }

    @PutMapping("/delete/{orderId}")
    public void deleteOrder(@PathVariable int orderId) {
        orderService.deleteOrder(orderId);
    }

    @PostMapping("/addProductToOrder")
    public ResponseEntity<String> addProductToOrder( @RequestBody AddProductToOrderDTO orderItem ) {
        orderService.addProductToOrder(orderItem);
        return ResponseEntity.ok("Product added to order successfully");
    }

    @PostMapping("/add")
    public void addOrder( @RequestBody OrderDTO order) {
        orderService.addOrder(order.getOrderNumber(), order.getOrderDate());
    }

    @PostMapping("/deleteItem/{itemId}")
    public void deleteItemFromOrder( @PathVariable int itemId ) {
        orderService.deleteItemFromOrder(itemId);
    }

    @PostMapping("/updateStatus")
    public void updateOrderStatus( @RequestBody UpdateOrderDTO updateOrder ) {
        orderService.updateOrderStatus(updateOrder.getOrderId(), updateOrder.getStatus());
    }
}
