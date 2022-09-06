package com.liguangda.controllers;

import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;
import com.google.gson.Gson;
import java.io.PrintWriter;
import com.liguangda.service.ICustomerService;
import com.liguangda.service.impl.CustomerServiceImpl;
import com.liguangda.bean.Customer;
import com.liguangda.controllers.UserUtils;

@WebServlet(urlPatterns = "/user")  // Why cannot "/" ?
public class UserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (! UserUtils.isSignedIn(req)) {
            resp.setStatus(401);  // No '/' prefix 
            return;
        }
        
        ICustomerService iCustomerService = new CustomerServiceImpl();
        int userId = Integer.parseInt(req.getParameter("userId"));

        try {
            Customer customerFound = iCustomerService.getUserInfo(userId);
            if (customerFound == null) {
                resp.setStatus(500);
                return;
            }

            String userInfoJSON = new Gson().toJson(customerFound);
            resp.setContentType("application/json");
            PrintWriter pw = resp.getWriter();
            pw.write(userInfoJSON);
            pw.flush();
        } catch (SQLException e) {
            resp.setStatus(500); 
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (! UserUtils.isSignedIn(req)) {
            resp.setStatus(401);  // No '/' prefix 
            return;
        }

        ICustomerService iCustomerService = new CustomerServiceImpl();
        int userId = Integer.parseInt(req.getParameter("userId"));
        String userAddress = req.getParameter("userAddress");

        try {
            if (iCustomerService.updateUserInfo(userId, userAddress) != 1) {
                resp.setStatus(500);
                return;
            }
        } catch (SQLException e) {
            resp.setStatus(500); 
        }
    }
}
