/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.ignite.tcsmail.servlets;

import com.tcs.ignite.tcsmail.beans.CmnUserDetails;
import com.tcs.ignite.tcsmail.beans.EmailCustomerDetails;
import com.tcs.ignite.tcsmail.beans.EmailStatusDetails;
import com.tcs.ignite.tcsmail.beans.EmailUserCustomerTransactionDetails;
import com.tcs.ignite.tcsmail.beans.MasterEmailStatus;
import com.tcs.ignite.tcsmail.services.DbUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bastianjoe
 */
public class SaveMailActivity extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/json");
        PrintWriter out = response.getWriter();
        HttpSession httpsession = request.getSession(true);
        String status = request.getParameter("status");
        if (status != null) {
            int userId = Integer.parseInt(httpsession.getAttribute("UserId").toString());
            int customerId = Integer.parseInt(httpsession.getAttribute("MappedCustomerId").toString());
            String from = request.getParameter("from");
            String to = request.getParameter("to");
            String cc = request.getParameter("cc");
            String subject = request.getParameter("subject");
            String content = request.getParameter("content");

            EmailUserCustomerTransactionDetails euctd = new EmailUserCustomerTransactionDetails();
            euctd.setTrCc(cc);
            euctd.setTrContent(content);
            euctd.setCreated(request.getParameter("date"));
            euctd.setUserId(new CmnUserDetails(userId));
            euctd.setEmailCustomerId(new EmailCustomerDetails(customerId));

            euctd.setTrFrom(from);
            euctd.setLastModified(new Date().toString());
            euctd.setTrSubject(subject);
            euctd.setTrTo(to);
            EmailStatusDetails esd = new EmailStatusDetails();
            esd.setCreated(new Date());
            esd.setLastModified(new Date());
            esd.setIsDeleted(false);
            esd.setIsVisible(true);
            esd.setStatusId(new MasterEmailStatus(Integer.parseInt(status)));
            try {
                out.println(DbUtils.saveMailActivity(euctd, esd));
            } catch (Exception ex) {
                out.println("{responseCode:0}");
            }
        } else {
            out.println("{responseCode:2}");
        }
    }

}
