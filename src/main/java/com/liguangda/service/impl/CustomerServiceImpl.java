package com.liguangda.service.impl;

import java.sql.SQLException;
import com.liguangda.bean.Customer;
import com.liguangda.dao.ICustomerDao;
import com.liguangda.dao.impl.CustomerDaoImpl;
import com.liguangda.service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService {
    
    private ICustomerDao iCustomerDao = new CustomerDaoImpl();
    
    @Override
    public Customer register(Customer customer) throws SQLException {
        return iCustomerDao.addCustomer(customer);
    }

    @Override
    public Customer signIn(String name, String password) throws SQLException {
        return iCustomerDao.getCustomer(name, password);
    }

    @Override
    public int updateUserInfo(int customerId, String customerAddress) throws SQLException {
        return iCustomerDao.updateCustomerInfo(customerId, customerAddress);
    }
    
    @Override
    public Customer getUserInfo(int customerId) throws SQLException {
        return iCustomerDao.getCustomerById(customerId);        
    }
}
