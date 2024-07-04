package com.cardenas.orders_app.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.cardenas.orders_app.model.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    /**
     * Function that creates a new order sending the following params.
     * @param order_number
     * @param p_order_date
     */
    @Transactional
    @Modifying
    @Query(value = "CALL sp_add_order(:p_order_number, :p_order_date)", nativeQuery = true)
    void addOrder(@Param("p_order_number") String order_number, @Param("p_order_date") LocalDate p_order_date);

    /**
     * Function that deletes a product from an order based on its ID.
     * @param p_order_item_id
     */
    @Transactional
    @Modifying
    @Query(value = "CALL sp_delete_order_item(:p_order_item_id)", nativeQuery = true)
    void deleteItemFromOrder(@Param("p_order_item_id") int p_order_item_id);

    /**
     * Function that updates an order's status.
     * @param p_order_id
     * @param p_new_status
     */
    @Transactional
    @Modifying
    @Query(value = "CALL sp_update_order_status(:p_order_id, :p_new_status)", nativeQuery = true)
    void updateOrderStatus(@Param("p_order_id") int p_order_id, @Param("p_new_status") String p_new_status);

    /**
     * Functions that list all orders.
     * @return a list of orders.
     */
    @Query(value = "CALL sp_list_orders()", nativeQuery = true)
    List<Object[]> listOrders();

    /**
     * Function that deletes an entire order.
     * @param orderId
     */
    @Transactional
    @Modifying
    @Query(value = "CALL sp_delete_order(:order_id)", nativeQuery = true)
    void deleteOrder(@Param("order_id") int orderId);

    /**
     * Function that add a new product to an order that exists.
     * @param orderId
     * @param productId
     * @param quantity
     */
    @Transactional
    @Modifying
    @Query(value = "CALL sp_add_product_to_order(:order_id, :product_id, :quantity)", nativeQuery = true)
    void addProductToOrder(@Param("order_id") int order_id, @Param("product_id") int product_id, @Param("quantity") int quantity);
}