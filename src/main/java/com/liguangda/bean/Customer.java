package com.liguangda.bean;

public class Customer {
     
    private int customerId;
    private String customerName;
    private String customerMobile;
    private String customerPassword;
    private String customerAddress;

    public Customer() {}

    public Customer(int customerId, String customerName, String customerMobile, String customerPassword) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerMobile = customerMobile;
        this.customerPassword = customerPassword;
    }

    public Customer(String customerName, String customerMobile, String customerPassword) {
        this.customerName = customerName;
        this.customerMobile = customerMobile;
        this.customerPassword = customerPassword;
    }

    public int getCustomerId() { return customerId; }

    public void setCustomerId(int customerId) { this.customerId = customerId;}

    public String getCustomerName() { return customerName; }

    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getCustomerMobile() { return customerMobile; }

    public void setCustomerMobile(String customerMobile) { this.customerMobile = customerMobile; }

    public String getCustomerPassword() { return customerPassword; }

    public void setCustomerPassword(String customerPassword) { this.customerPassword = customerPassword; }

    public String getCustomerAddress() { return customerAddress; }

    public void setCustomerAddress(String customerAddress) { this.customerAddress = customerAddress; }

    @Override
    public String toString() {
        return "Customer{" +
               "customerId='" + customerId + '\'' +
               ", customerName='" + customerName + '\'' +
               ", customerMobile='" + customerMobile + '\'' +
               ", customerPassword='" + customerPassword + '\'' +
               ", customerAddress='" + customerAddress + '\'' +
               '}';       
    }
}
