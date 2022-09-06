package com.liguangda.service;

import java.sql.SQLException;
import com.liguangda.bean.Customer;

public interface ICustomerService {

    public Customer register(Customer customer) throws SQLException;
    public Customer signIn(String name, String password) throws SQLException;
    public int updateUserInfo(int customerId, String customerAddress) throws SQLException;
    public Customer getUserInfo(int customerId) throws SQLException;
}
