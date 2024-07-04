package com.cardenas.orders_app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cardenas.orders_app.entity.Order;
import com.cardenas.orders_app.entity.dto.AddProductToOrderDTO;
import com.cardenas.orders_app.service.OrderService;

@RestController
@RequestMapping(path = "api/v1/orders")
@CrossOrigin(origins = "http://localhost:54224")
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
    public ResponseEntity<String> addProductToOrder(@RequestBody AddProductToOrderDTO orderItem) {
        orderService.addProductToOrder(orderItem);
        return ResponseEntity.ok("Product added to order successfully");
    }

    @PostMapping("/add")
    public void addOrder( @RequestBody Order order) {
        orderService.addOrder(order.getOrderNumber(), order.getOrderDate(), order.getStatus());
    }
}
