package com.cardenas.orders_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cardenas.orders_app.model.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}