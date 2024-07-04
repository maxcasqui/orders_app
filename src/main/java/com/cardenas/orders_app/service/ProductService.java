package com.cardenas.orders_app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cardenas.orders_app.entity.Product;
import com.cardenas.orders_app.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product addProduct(String productName, Double unitPrice) {
        Product product = new Product();
        product.setProductName(productName);
        product.setUnitPrice(unitPrice);
        return productRepository.save(product);
    }

    public Product updateProduct(Integer productId, String productName, Double unitPrice) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            product.setProductName(productName);
            product.setUnitPrice(unitPrice);
            return productRepository.save(product);
        }
        return null;
    }
}
