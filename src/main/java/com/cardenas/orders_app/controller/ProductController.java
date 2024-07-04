package com.cardenas.orders_app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cardenas.orders_app.entity.Product;
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

    @PostMapping("/add")
    public ResponseEntity<Object> addProduct(@RequestBody Product product ) {

        Product p = productService.addProduct(product.getProductName(), product.getUnitPrice());

        if (p == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add product");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("Product added successfully");
    }


    @PutMapping("/update/{productId}")
    public ResponseEntity<Object> updateProduct(
            @PathVariable int productId,
            @RequestParam("productName") String productName,
            @RequestParam("unitPrice") Double unitPrice,
            @RequestParam("description") String description) {

        Product updatedProduct = productService.updateProduct(productId, productName, unitPrice);

        if (updatedProduct == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found or failed to update");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Product updated successfully");
    }

}
