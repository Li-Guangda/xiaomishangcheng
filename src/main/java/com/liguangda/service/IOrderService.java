package com.liguangda.service;

import java.util.List;
import java.sql.SQLException;
import com.liguangda.bean.Order;

public interface IOrderService {

    public int addOrder(Order order) throws SQLException;

    public List<Order> getAllOrders(int customerId) throws SQLException;

    public Order getOrderById(int orderId) throws SQLException;

    public int deleteOrder(int orderId) throws SQLException;
}
