package com.cardenas.orders_app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cardenas.orders_app.model.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    /**
     * Function that list all products from an order.
     * @return a List of ProductFromOrderDTO
     */
    @Query(value = "CALL sp_list_products_by_order(:order_id)", nativeQuery = true)
    List<Object[]> listProductsFromOrder(@Param("order_id") int order_id);
}