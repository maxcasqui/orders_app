package com.cardenas.orders_app.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cardenas.orders_app.model.dto.ProductFromOrderDTO;
import com.cardenas.orders_app.model.entity.Product;
import com.cardenas.orders_app.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<ProductFromOrderDTO> getProductsFromOrder(int orderId) {
        List<Object[]> listProductsFromOrder = productRepository.listProductsFromOrder(orderId);

        List<ProductFromOrderDTO> resultList = listProductsFromOrder.stream().map(
            product -> new ProductFromOrderDTO(
                (Integer) product[0],
                (Integer) product[1],
                (String) product[2],
                (Integer) product[3],
                ((BigDecimal) product[4]).doubleValue()
            )
        ).collect(Collectors.toList());

        return resultList;
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
