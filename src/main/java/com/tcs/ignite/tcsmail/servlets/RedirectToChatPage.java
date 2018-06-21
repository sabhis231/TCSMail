/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.ignite.tcsmail.servlets;

import com.tcs.ignite.tcsmail.services.DbUtils;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bastianjoe
 */
public class RedirectToChatPage extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/json");
        PrintWriter out = response.getWriter();
        HttpSession httpsession = request.getSession(true);
        httpsession.setAttribute("MappedCustomerId", request.getParameter("emailCustomerId"));
        httpsession.setAttribute("MappedCustomerName", request.getParameter("emailCustomerName").replaceAll("\\<\\<del\\>\\>", " "));
        out.print("{\"responseCode\":1}");
    }
    
}
