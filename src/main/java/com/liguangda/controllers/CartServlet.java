package com.liguangda.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import com.google.gson.Gson;
import com.liguangda.service.IOrderService;
import com.liguangda.service.IGoodsService;
import com.liguangda.service.impl.OrderServiceImpl;
import com.liguangda.service.impl.GoodsServiceImpl;
import com.liguangda.controllers.UserUtils;
import com.liguangda.bean.Order;
import com.liguangda.bean.Goods;

import java.io.PrintWriter;

@WebServlet(urlPatterns = "/cart")  // Why cannot "/" ?
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (! UserUtils.isSignedIn(req)) {
            resp.setStatus(401);  // No '/' prefix 
            return;
        }

        IOrderService iOrderService = new OrderServiceImpl(); 
        IGoodsService iGoodsService = new GoodsServiceImpl();

        try{
            int customerId = Integer.parseInt(req.getParameter("customerId")); 

            List<Order> orders = iOrderService.getAllOrders(customerId);
            List<Goods> goods =  new ArrayList<Goods>();
            for (int i = 0; i < orders.size(); i++) {
                int goodsId = orders.get(i).getGoodsId();
                goods.add(iGoodsService.getGoodsById(goodsId));  
            }

            String ordersJSON = new Gson().toJson(orders);
            String goodsJSON = new Gson().toJson(goods);
            String ordersAndGoodsJSON = "[" + ordersJSON + "," + goodsJSON + "]";
                
            resp.setContentType("application/json");
            PrintWriter pw = resp.getWriter();
            pw.write(ordersAndGoodsJSON);
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
        
        IOrderService iOrderService = new OrderServiceImpl(); 
        IGoodsService iGoodsService = new GoodsServiceImpl();

        try {
            int customerId = Integer.parseInt(req.getParameter("customerId"));
            int goodsId = Integer.parseInt(req.getParameter("goodsId"));
            int goodsNumber = Integer.parseInt(req.getParameter("goodsNumber"));

            Goods goods = iGoodsService.getGoodsById(goodsId); 

            Order order = new Order();
            order.setCustomerId(customerId);
            order.setGoodsId(goodsId);
            order.setOrderNumber(goodsNumber);
            order.setOrderAmount(goods.getGoodsPrice() * goodsNumber);

            if (iOrderService.addOrder(order) != 1) {
                resp.setStatus(400);        
                return;
            }
        } catch (SQLException e) {
            resp.setStatus(500); 
        }
    }

    
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IOrderService iOrderService = new OrderServiceImpl(); 
        IGoodsService iGoodsService = new GoodsServiceImpl();
        int orderId = Integer.parseInt(req.getParameter("orderId"));

        try {
            // Get Order number
            Order orderFound = iOrderService.getOrderById(orderId);
            if (orderFound == null) {
                resp.setStatus(500);
                return;
            }

            // Get Goods stock
            Goods goodsFound = iGoodsService.getGoodsById(orderFound.getGoodsId());
            if (goodsFound == null) {
                resp.setStatus(500);
                return;
            }

            // update Goods stock
            int ret = iGoodsService.updateStock(
                goodsFound.getGoodsId(), 
                goodsFound.getGoodsStock() + orderFound.getOrderNumber()
            );
            if (ret != 1) {
                resp.setStatus(500);
                return;
            }

            // delete order
            if (iOrderService.deleteOrder(orderId) != 1) {
                resp.setStatus(500);
                return;
            }
        } catch (SQLException e) {
            resp.setStatus(500); 
        }
    } 
}
