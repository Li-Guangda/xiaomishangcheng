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
import com.liguangda.service.IGoodsService;
import com.liguangda.service.impl.GoodsServiceImpl;
import com.liguangda.bean.Goods;

@WebServlet(urlPatterns = "/index")  // Why cannot "/" ?
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IGoodsService iGoodsService = new GoodsServiceImpl();

        try {
            List<Goods> goodsList = iGoodsService.getAllGoods();
            req.getSession().setAttribute("goodsList", goodsList);
            req.getRequestDispatcher("WEB-INF/pages/index.jsp")
               .forward(req, resp);
        } catch (SQLException throwables) {
            System.out.println(throwables);
            resp.setStatus(500);    
        }
    }
}
