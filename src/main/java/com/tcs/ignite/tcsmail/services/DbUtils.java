/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.ignite.tcsmail.services;

import com.tcs.ignite.tcsmail.beans.CmnUserDetails;
import com.tcs.ignite.tcsmail.beans.EmailCustomerDetails;
import com.tcs.ignite.tcsmail.beans.EmailCustomerMappingDetails;
import com.tcs.ignite.tcsmail.beans.EmailUserCustomerTransactionDetails;
import com.tcs.ignite.tcsmail.beans.MasterRole;
//import com.tcs.ignite.tcsmail.utils.Connection;
import com.tcs.ignite.tcsmail.utils.HibernateUtil;
import java.util.List;
import jdk.nashorn.api.scripting.JSObject;
import org.hibernate.Query;
import org.hibernate.Session;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author bastianjoe
 */
public class DbUtils {

    public static List findByHQLQuery(Session session, final String queryString, final Object... values) {
//        String hqlQuery = PropertyFile.fetchPropertyDirectly(SQL_PROPERTY_FILE, queryString);
        List list = null;
        try {
            Query query = session.createQuery(queryString);
            if (values != null) {
                for (int i = 0; i < values.length; i++) {
                    query.setParameter(i, values[i]);
                }
            }
            return list = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object[] getParametersObjectArray(Object... args) {
        return args;
    }

    public static CmnUserDetails doauth(CmnUserDetails cmnuserdetails) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String hql = "SELECT c FROM CmnUserDetails c WHERE c.primaryEmail = :email and c.password = :password and c.isDeleted = 0 and c.isVisible = 1";
            Query query = session.createQuery(hql);
            query.setParameter("email", cmnuserdetails.getPrimaryEmail());
            query.setParameter("password", cmnuserdetails.getPassword());
            cmnuserdetails = (CmnUserDetails) query.uniqueResult();
            session.close();
        } catch (Exception ex) {
            return null;
        }
        return cmnuserdetails;
    }

    public static JSONObject fetchUserMappedCustomer(int userId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        JSONObject object = new JSONObject();
        JSONArray array = new JSONArray();
        try {
            String str = "select  c from EmailCustomerMappingDetails c where c.userId=? and c.isDeleted=0 and c.isVisible=1";
            List<EmailCustomerMappingDetails> listEmailCustomerMappingDetails = findByHQLQuery(session, str, getParametersObjectArray(new CmnUserDetails(userId)));
            for (EmailCustomerMappingDetails ecmd : listEmailCustomerMappingDetails) {
                JSONObject jsono = new JSONObject();
                jsono.put("tcsEmailCustomerName", ecmd.getEmailCustomerId().getCustomerName().replaceAll("\"", ""));
                jsono.put("tcsEmailCustomerId", ecmd.getEmailCustomerId().getEmailCustomerId());
                jsono.put("tcsEmailCustomerFullName", ecmd.getEmailCustomerId().getCustomerName().replaceAll("\"", "").replaceAll(" ", "<<del>>"));
                array.add(jsono);
            }
            object.put("tcsEmailMappedCustomerData", array);
            object.put("responseCode", 1);

        } catch (Exception ex) {
            ex.printStackTrace();
            object.put("responseCode", 0);

        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
        return object;

    }

    public static JSONObject fetchCustomerChats(int mappedCustomerId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        JSONObject object = new JSONObject();
        JSONArray array = new JSONArray();
        try {
            String str = "select  c from EmailUserCustomerTransactionDetails c where c.emailCustomerId=?  order by c.transactionId desc";
            List<EmailUserCustomerTransactionDetails> listEmailUserCustomerTransactionDetails = findByHQLQuery(session, str, getParametersObjectArray(new EmailCustomerDetails(mappedCustomerId)));
            for (EmailUserCustomerTransactionDetails euctd : listEmailUserCustomerTransactionDetails) {
                JSONObject jsono = new JSONObject();
                jsono.put("tcsEmailCustomerName", euctd.getEmailCustomerId().getCustomerName().trim());
                jsono.put("tcsEmailCustomerId", euctd.getEmailCustomerId().getEmailCustomerId());
                jsono.put("tcsEmailBcc", euctd.getTrCc().replaceAll("\\<\\<del\\>\\>", ",").replaceAll("\\ú", "").trim());
                jsono.put("tcsEmailContent", euctd.getTrContent().replaceAll("\\<\\<del\\>\\>", ",").replaceAll("\\ú", "").trim());
                jsono.put("tcsEmailCreatedBy", euctd.getUserId().getUserName().trim());
                jsono.put("tcsEmailFrom", euctd.getTrFrom().replaceAll("\\<\\<del\\>\\>", ",").replaceAll("\\ú", "").trim().replaceAll("\"", ""));
                jsono.put("tcsEmailLastModified", euctd.getLastModified().toString().trim());
                jsono.put("tcsEmailSubject", euctd.getTrSubject().replaceAll("\\<\\<del\\>\\>", ",").replaceAll("\\ú", "").trim());
                jsono.put("tcsEmailTo", euctd.getTrTo().replaceAll("\\<\\<del\\>\\>", ",").replaceAll("\\ú", "").trim());
                jsono.put("tcsEmailTransactionId", euctd.getTransactionId());
                jsono.put("tcsEmailCreated", euctd.getCreated().toString());
                array.add(jsono);
            }
            object.put("tcsEmailMappedCustomerData", array);
            object.put("responseCode", 1);

        } catch (Exception ex) {
            ex.printStackTrace();
            object.put("responseCode", 0);

        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
        return object;

    }

    public static JSONObject saveMailActivity(EmailUserCustomerTransactionDetails euctd1) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        JSONObject object = new JSONObject();
        JSONArray array = new JSONArray();
        try {
            session.beginTransaction();
            session.save(euctd1);
            session.getTransaction().commit();
            String str = "select  c from EmailUserCustomerTransactionDetails c where c.emailCustomerId=?  order by c.transactionId desc";
            List<EmailUserCustomerTransactionDetails> listEmailUserCustomerTransactionDetails = findByHQLQuery(session, str, getParametersObjectArray(euctd1.getEmailCustomerId()));
            for (EmailUserCustomerTransactionDetails euctd : listEmailUserCustomerTransactionDetails) {
                JSONObject jsono = new JSONObject();
                jsono.put("tcsEmailCustomerName", euctd.getEmailCustomerId().getCustomerName());
                jsono.put("tcsEmailCustomerId", euctd.getEmailCustomerId().getEmailCustomerId());
                jsono.put("tcsEmailBcc", euctd.getTrCc().replaceAll("\\<\\<del\\>\\>", ",").replaceAll("\\ú", ""));
                jsono.put("tcsEmailContent", euctd.getTrContent().replaceAll("\\<\\<del\\>\\>", ",").replaceAll("\\ú", ""));
                jsono.put("tcsEmailCreatedBy", euctd.getUserId().getUserName());
                jsono.put("tcsEmailFrom", euctd.getTrFrom().replaceAll("\\<\\<del\\>\\>", ",").replaceAll("\\ú", ""));
                jsono.put("tcsEmailLastModified", euctd.getLastModified().toString());
                jsono.put("tcsEmailSubject", euctd.getTrSubject().replaceAll("\\<\\<del\\>\\>", ",").replaceAll("\\ú", ""));
                jsono.put("tcsEmailTo", euctd.getTrTo().replaceAll("\\<\\<del\\>\\>", ",").replaceAll("\\ú", ""));
                jsono.put("tcsEmailTransactionId", euctd.getTransactionId());
                jsono.put("tcsEmailCreated", euctd.getCreated().toString());
                array.add(jsono);
            }
            object.put("tcsEmailMappedCustomerData", array);
            object.put("responseCode", 1);

        } catch (Exception ex) {
            ex.printStackTrace();
            object.put("responseCode", 0);

        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
        return object;
    }

    public static JSONObject fetchAllUser() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        JSONObject object = new JSONObject();
        JSONArray array = new JSONArray();
        try {
            String str = "select  c from CmnUserDetails c where c.roleId=? and c.isDeleted=0 and c.isVisible=1";
            List<CmnUserDetails> listEmailCmnUserDetails = findByHQLQuery(session, str, getParametersObjectArray(new MasterRole(3)));
            for (CmnUserDetails cud : listEmailCmnUserDetails) {
                JSONObject jsono = new JSONObject();
                jsono.put("tcsEmailUserName", cud.getUserName());
                jsono.put("tcsEmailUserId", cud.getUserId());
                jsono.put("tcsEmailPrimaryEmail", cud.getPrimaryEmail());
                
                array.add(jsono);
            }
            object.put("tcsEmailMappedUserData", array);
            object.put("responseCode", 1);

        } catch (Exception ex) {
            ex.printStackTrace();
            object.put("responseCode", 0);

        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
        return object;

    }

}
