package com.liguangda.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;
import com.liguangda.service.ICustomerService;
import com.liguangda.service.impl.CustomerServiceImpl;
import com.liguangda.bean.Customer;
import com.liguangda.bean.Goods;
import com.liguangda.service.IGoodsService;
import com.liguangda.service.impl.GoodsServiceImpl;

import java.io.PrintWriter;

@WebServlet(urlPatterns = "/test")  // Why cannot "/" ?
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IGoodsService iGoodsService = new GoodsServiceImpl(); 
        try {
            /*
            Customer signInCustomer = iCustomerService.signIn("lgd", "123456"); 
            */
            Goods goodsFound = iGoodsService.getGoodsById(15);
            resp.setContentType("text/html");
            PrintWriter pw = resp.getWriter();
            pw.write(goodsFound.toString());
            pw.flush();
        } catch (SQLException throwables) {
            System.out.println(throwables);
            resp.setStatus(500);    
        }
    }

    /*
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
    */
}
