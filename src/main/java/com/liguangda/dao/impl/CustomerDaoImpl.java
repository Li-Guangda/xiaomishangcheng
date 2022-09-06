package com.liguangda.dao.impl;

import java.sql.SQLException;
import com.liguangda.dao.ICustomerDao;
import com.liguangda.bean.Customer;
import com.liguangda.utils.MyDBUtils;

public class CustomerDaoImpl implements ICustomerDao {
    
    @Override
    public Customer addCustomer(Customer customer) throws SQLException {
        String sql = "INSERT INTO customers (customerName, customerMobile, customerPassword) VALUES(?, ?, ?)"; 
        return MyDBUtils.insert(sql, new Object[] {
            customer.getCustomerName(),
            customer.getCustomerMobile(),
            customer.getCustomerPassword()
        }, Customer.class);
    }

    @Override
    public Customer getCustomer(String name, String password) throws SQLException {
        String sql = "SELECT * FROM customers WHERE customerName = ? and customerPassword = ?";
        return MyDBUtils.queryOne(sql, new Object[] {
            name, 
            password
        }, Customer.class);
    } 

    @Override
    public Customer getCustomerById(int customerId) throws SQLException {
        String sql = "SELECT * FROM customers WHERE customerId = ?";
        return MyDBUtils.queryOne(sql, new Object[] {
            customerId
        }, Customer.class);
    }

    @Override
    public int updateCustomerInfo(int customerId, String customerAddress) throws SQLException {
        String sql = "UPDATE customers SET customerAddress = ? WHERE customerId = ?"; 
        return MyDBUtils.update(sql, new Object[]{
            customerAddress, 
            customerId
        });
    }
}
