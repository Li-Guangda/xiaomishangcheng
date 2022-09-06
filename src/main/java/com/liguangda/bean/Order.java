package com.liguangda.bean;

import java.sql.Timestamp;

public class Order {
    
    private int orderId;
    private int customerId;
    private int goodsId;
    private int orderNumber;
    private double orderAmount;
    private String orderStatus;
    private Timestamp orderDate;

    public int getOrderId() { return orderId; }

    public void setOrderId(int orderId) { this.orderId = orderId; }

    public int getCustomerId() { return customerId; }

    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public int getGoodsId() { return goodsId; }

    public void setGoodsId(int goodsId) { this.goodsId = goodsId; }

    public int getOrderNumber() { return orderNumber; }

    public void setOrderNumber(int orderNumber) { this.orderNumber = orderNumber; }

    public double getOrderAmount() { return orderAmount; }

    public void setOrderAmount(double orderAmount) { this.orderAmount = orderAmount; }

    public String getOrderStatus() { return orderStatus; }

    public void setOrderStatus(String OrderStatus) { this.orderStatus = orderStatus; }

    public Timestamp getOrderDate() { return orderDate; }

    public void setOrderDate(Timestamp orderDate) { this.orderDate = orderDate; }

    @Override
    public String toString() {
        return "Order(" + 
               "orderId=" + orderId +
               "customerId=" + customerId +
               "goodsId=" + goodsId +
               "orderNumber=" + orderNumber +
               "orderAmount=" + orderAmount +
               "orderStatus='" + orderStatus + '\'' +
               "orderDate=" + orderDate +
               ")";
    }
}
