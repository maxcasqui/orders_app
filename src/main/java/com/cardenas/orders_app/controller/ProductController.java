package com.cardenas.orders_app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cardenas.orders_app.model.dto.ProductFromOrderDTO;
import com.cardenas.orders_app.model.entity.Product;
import com.cardenas.orders_app.service.ProductService;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
    }

    @GetMapping("/listProductsFromOrder/{orderId}")
    public ResponseEntity<List<ProductFromOrderDTO>> getProductsFromOrder(@PathVariable int orderId) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductsFromOrder(orderId));
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addProduct(@RequestBody Product product ) {

        Product p = productService.addProduct(product.getProductName(), product.getUnitPrice());

        if (p == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add product");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("Product added successfully");
    }

}
