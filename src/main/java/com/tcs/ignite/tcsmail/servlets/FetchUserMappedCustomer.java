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
 * @author sabhis231
 */
public class FetchUserMappedCustomer extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/json");
        PrintWriter out = response.getWriter();
        HttpSession httpsession = request.getSession(true);
        int userId = Integer.parseInt(httpsession.getAttribute("UserId").toString());
        if (httpsession.getAttribute("MappedUserId") != null) {
            userId = Integer.parseInt(httpsession.getAttribute("MappedUserId").toString());
        }
        try {
            out.println(DbUtils.fetchUserMappedCustomer(userId));
        } catch (Exception ex) {
            out.println("{responseCode:0}");
        }
    }

}
