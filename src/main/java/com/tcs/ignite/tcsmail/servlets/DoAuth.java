/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.ignite.tcsmail.servlets;

import com.tcs.ignite.tcsmail.beans.CmnUserDetails;
import com.tcs.ignite.tcsmail.services.DbUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;

/**
 *
 * @author sabhis231
 */
public class DoAuth extends HttpServlet {

    JSONObject jsonobject = new JSONObject();
//    static final Logger logger = Logger.getLogger(Auth.class);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        try {
            HttpSession httpsession = request.getSession(true);
            CmnUserDetails cmnuserdetails = new CmnUserDetails();
            String UserName = request.getParameter("userName");
            String Password = request.getParameter("password");
            cmnuserdetails.setPrimaryEmail(UserName);
            cmnuserdetails.setPassword(Password);
            cmnuserdetails = DbUtils.doauth(cmnuserdetails);
            if (cmnuserdetails != null) {
                jsonobject.put("responseCode", 1);
                jsonobject.put("doauth", true);
                jsonobject.put("role", cmnuserdetails.getRoleId().getRole());
                httpsession.setAttribute("UserId", cmnuserdetails.getUserId());
                httpsession.setAttribute("ImagePath", cmnuserdetails.getImagePath());
                httpsession.setAttribute("UserName", cmnuserdetails.getUserName().trim());
                httpsession.setAttribute("Role", cmnuserdetails.getRoleId().getRole());
                httpsession.setAttribute("PrimaryEmail", cmnuserdetails.getPrimaryEmail());
//                httpsession.setAttribute("IgniteId", cmnuserdetails.getIgniteId());
//                httpsession.setAttribute("IpAddress", cmnuserdetails.getIpAddress());
                String ipAddress = request.getHeader("X-FORWARDED-FOR");
                if (ipAddress == null) {
                    ipAddress = request.getRemoteAddr();
                }

//                logger.info("LoginSuccess - " + "Ignite" + cmnuserdetails.getIgniteId() + " | " + cmnuserdetails.getPrimaryEmail() + " @ " + ipAddress);
            } else {
                jsonobject.put("responseCode", 0);
                jsonobject.put("doauth", false);
//                logger.warn("login_failed - " + UserName);
            }

            out.println(jsonobject);
        } catch (Exception ex) {
//            logger.error("err_auth - " + ex);
            out.println("{responseCode: 0}");
        }

    }

}
