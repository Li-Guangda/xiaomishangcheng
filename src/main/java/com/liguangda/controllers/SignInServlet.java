package com.liguangda.controllers; 

import java.io.IOException; 
import java.sql.SQLException; 
import jakarta.servlet.ServletException; 
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpSession; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
import jakarta.servlet.annotation.WebServlet; 
import jakarta.servlet.RequestDispatcher; 
import com.liguangda.service.ICustomerService; 
import com.liguangda.service.impl.CustomerServiceImpl; 
import com.liguangda.bean.Customer;

@WebServlet(urlPatterns = "/signin")
public class SignInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (UserUtils.isSignedIn(req)) {
            resp.sendRedirect("index");  // No '/' prefix 
        } else {  // else or return!!! Orz
            req.getRequestDispatcher("WEB-INF/pages/signin.jsp")
               .forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ICustomerService iCustomerService = new CustomerServiceImpl(); 

        String name = req.getParameter("name");
        String password = req.getParameter("password");

        try {
            Customer customerFound = iCustomerService.signIn(name, password); 
            if (customerFound == null) {
             resp.setStatus(401);   
             return;
            }
            HttpSession session = req.getSession();
            session.setAttribute("userId", customerFound.getCustomerId());
            session.setAttribute("userName", customerFound.getCustomerName());
            session.setAttribute("userMobile", customerFound.getCustomerMobile());
            return;  // !!!
        } catch (SQLException e) {
            System.out.println(e); 
            resp.setStatus(500);
        }
    }
}
