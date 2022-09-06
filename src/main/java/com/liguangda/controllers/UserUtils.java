package com.liguangda.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class UserUtils {
    
    public static boolean isSignedIn(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("userName");  
        return userName != null;
    }
}
