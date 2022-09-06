package com.liguangda.controllers;

import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import com.liguangda.service.ICustomerService;
import com.liguangda.service.impl.CustomerServiceImpl;
import com.liguangda.bean.Customer;


@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (UserUtils.isSignedIn(req)) {
            resp.sendRedirect("index");  // Not /index 
        } else {  // else or return!!! Orz
            req.getRequestDispatcher("WEB-INF/pages/register.jsp")
               .forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ICustomerService iCustomerService = new CustomerServiceImpl(); 
        
        String name = req.getParameter("name");
        String mobile = req.getParameter("mobile");
        String password = req.getParameter("password");
        var customer = new Customer(name, mobile, password);

        try {
            Customer regCustomer = iCustomerService.register(customer);        
            if (regCustomer == null) throw new SQLException();
        } catch (SQLException e) {
            System.out.println(e); 
            resp.setStatus(500);
        }
    }
}
