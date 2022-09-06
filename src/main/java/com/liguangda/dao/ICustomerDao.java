package com.liguangda.dao;

import java.sql.SQLException;
import com.liguangda.bean.Customer;

public interface ICustomerDao {
     
    public Customer addCustomer(Customer customer) throws SQLException;

    public Customer getCustomer(String name, String password) throws SQLException; 

    public Customer getCustomerById(int customerId) throws SQLException;

    public int updateCustomerInfo(int customerId, String customerAddress) throws SQLException;
}
