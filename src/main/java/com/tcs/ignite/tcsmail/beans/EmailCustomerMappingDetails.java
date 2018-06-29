/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.ignite.tcsmail.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bastianjoe
 */
@Entity
@Table(name = "email_customer_mapping_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmailCustomerMappingDetails.findAll", query = "SELECT e FROM EmailCustomerMappingDetails e")})
public class EmailCustomerMappingDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "email_customer_mapping_id")
    private Integer emailCustomerMappingId;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "is_deleted")
    private Boolean isDeleted;
    @Column(name = "is_visible")
    private Boolean isVisible;
    @JoinColumn(name = "email_customer_id", referencedColumnName = "email_customer_id")
    @ManyToOne(optional = false)
    private EmailCustomerDetails emailCustomerId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private CmnUserDetails userId;

    public EmailCustomerMappingDetails() {
    }

    public EmailCustomerMappingDetails(Integer emailCustomerMappingId) {
        this.emailCustomerMappingId = emailCustomerMappingId;
    }

    public Integer getEmailCustomerMappingId() {
        return emailCustomerMappingId;
    }

    public void setEmailCustomerMappingId(Integer emailCustomerMappingId) {
        this.emailCustomerMappingId = emailCustomerMappingId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Boolean getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(Boolean isVisible) {
        this.isVisible = isVisible;
    }

    public EmailCustomerDetails getEmailCustomerId() {
        return emailCustomerId;
    }

    public void setEmailCustomerId(EmailCustomerDetails emailCustomerId) {
        this.emailCustomerId = emailCustomerId;
    }

    public CmnUserDetails getUserId() {
        return userId;
    }

    public void setUserId(CmnUserDetails userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailCustomerMappingId != null ? emailCustomerMappingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailCustomerMappingDetails)) {
            return false;
        }
        EmailCustomerMappingDetails other = (EmailCustomerMappingDetails) object;
        if ((this.emailCustomerMappingId == null && other.emailCustomerMappingId != null) || (this.emailCustomerMappingId != null && !this.emailCustomerMappingId.equals(other.emailCustomerMappingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tcs.ignite.tcsmail.beans.EmailCustomerMappingDetails[ emailCustomerMappingId=" + emailCustomerMappingId + " ]";
    }
    
}
