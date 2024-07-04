package com.cardenas.orders_app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cardenas.orders_app.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "CALL sp_list_orders()", nativeQuery = true)
    List<Object[]> listOrders();

    @Query(value = "CALL sp_delete_order(:orderId)", nativeQuery = true)
    void deleteOrder(@Param("orderId") int orderId);

    @Query(value = "CALL sp_add_product_to_order(:orderId, :productId, :quantity)", nativeQuery = true)
    void addProductToOrder(@Param("orderId") int orderId, @Param("productId") int productId, @Param("quantity") int quantity);
}