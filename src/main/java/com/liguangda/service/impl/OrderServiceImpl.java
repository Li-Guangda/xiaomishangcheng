package com.liguangda.service.impl;

import java.util.List;
import java.sql.SQLException;
import com.liguangda.bean.Order;
import com.liguangda.bean.Goods;
import com.liguangda.service.IOrderService;
import com.liguangda.dao.IGoodsDao;
import com.liguangda.dao.IOrderDao;
import com.liguangda.dao.impl.GoodsDaoImpl;
import com.liguangda.dao.impl.OrderDaoImpl;

public class OrderServiceImpl implements IOrderService {
    
    IGoodsDao iGoodsDao = new GoodsDaoImpl();
    IOrderDao iOrderDao = new OrderDaoImpl();
    
    @Override
    public int addOrder(Order order) throws SQLException {
        // First check whether the order exists.
        Order orderFound = iOrderDao.getOrder(order.getCustomerId(), order.getGoodsId());
        Goods goods = iGoodsDao.getGoodsById(order.getGoodsId());

        if (orderFound == null) {
            iOrderDao.addOrder(order); 

        } else {
            int totalNumber = orderFound.getOrderNumber() + order.getOrderNumber();
            double totalAmount = orderFound.getOrderAmount() + order.getOrderAmount();
            iOrderDao.updateOrderNumber(orderFound.getOrderId(), totalNumber, totalAmount); 
        }
        return iGoodsDao.updateStock(order.getGoodsId(), goods.getGoodsStock() - order.getOrderNumber());
    }

    @Override
    public List<Order> getAllOrders(int customerId) throws SQLException {
        return iOrderDao.getAllOrders(customerId);
    }

    @Override
    public Order getOrderById(int orderId) throws SQLException {
        return iOrderDao.getOrderById(orderId); 
    }

    @Override
    public int deleteOrder(int orderId) throws SQLException {
        return iOrderDao.deleteOrder(orderId);   
    }
}
