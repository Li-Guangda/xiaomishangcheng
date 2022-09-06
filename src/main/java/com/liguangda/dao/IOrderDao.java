package com.liguangda.dao;

import java.util.List;
import java.sql.SQLException;
import com.liguangda.bean.Order;

public interface IOrderDao {
    
    public Order addOrder(Order order) throws SQLException;

    public List<Order> getAllOrders(int customerId) throws SQLException;

    public Order getOrder(int customerId, int goodsId) throws SQLException;

    public Order getOrderById(int orderId) throws SQLException;

    public int updateOrderNumber(int orderId, int orderNumber, double orderAmount) throws SQLException;

    public int deleteOrder(int orderId) throws SQLException;
}
