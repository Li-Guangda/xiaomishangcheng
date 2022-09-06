package com.liguangda.dao.impl;

import java.util.List;
import java.sql.SQLException;
import com.liguangda.utils.MyDBUtils;
import com.liguangda.dao.IOrderDao;
import com.liguangda.bean.Order;
import com.liguangda.utils.MyDBUtils;

public class OrderDaoImpl implements IOrderDao {
    
    @Override
    public Order addOrder(Order order) throws SQLException {
        String sql = "INSERT INTO orders (customerId, goodsId, orderNumber, orderAmount) VALUE (?, ?, ?, ?)";
        return MyDBUtils.insert(sql, new Object[]{
            order.getCustomerId(),
            order.getGoodsId(),
            order.getOrderNumber(),
            order.getOrderAmount()
        }, Order.class);
    }

    @Override    
    public List<Order> getAllOrders(int customerId) throws SQLException {
        String sql = "SELECT * FROM orders WHERE customerId = ?"; 
        return MyDBUtils.query(sql, new Object[]{ customerId }, Order.class);
    }

    @Override
    public Order getOrder(int customerId, int goodsId) throws SQLException {
        String sql = "SELECT * FROM orders WHERE customerId = ? AND goodsId = ?";
        return MyDBUtils.queryOne(sql, new Object[]{
            customerId,
            goodsId
        }, Order.class);
    }

    @Override
    public Order getOrderById(int orderId) throws SQLException {
        String sql = "SELECT * FROM orders WHERE orderId = ?";
        return MyDBUtils.queryOne(sql, new Object[]{
            orderId
        }, Order.class);
    }


    @Override
    public int updateOrderNumber(int orderId, int orderNumber, double orderAmount) throws SQLException {
        String sql = "UPDATE orders SET orderNumber = ?, orderAmount = ? WHERE orderId = ?";
        return MyDBUtils.update(sql, new Object[]{
            orderNumber,
            orderAmount,
            orderId
        });
    }

    @Override
    public int deleteOrder(int orderId) throws SQLException {
        String sql = "DELETE FROM orders WHERE orderId = ?";   
        return MyDBUtils.update(sql, new Object[]{
            orderId  
        });
    }
}
