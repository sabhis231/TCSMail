/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.ignite.tcsmail.beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bastianjoe
 */
@Entity
@Table(name = "email_customer_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmailCustomerDetails.findAll", query = "SELECT e FROM EmailCustomerDetails e")
    , @NamedQuery(name = "EmailCustomerDetails.findByEmailCustomerId", query = "SELECT e FROM EmailCustomerDetails e WHERE e.emailCustomerId = :emailCustomerId")
    , @NamedQuery(name = "EmailCustomerDetails.findByCreated", query = "SELECT e FROM EmailCustomerDetails e WHERE e.created = :created")
    , @NamedQuery(name = "EmailCustomerDetails.findByIsDeleted", query = "SELECT e FROM EmailCustomerDetails e WHERE e.isDeleted = :isDeleted")
    , @NamedQuery(name = "EmailCustomerDetails.findByIsVisible", query = "SELECT e FROM EmailCustomerDetails e WHERE e.isVisible = :isVisible")})
public class EmailCustomerDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "email_customer_id")
    private Integer emailCustomerId;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Lob
    @Size(max = 65535)
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "is_deleted")
    private Boolean isDeleted;
    @Column(name = "is_visible")
    private Boolean isVisible;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emailCustomerId")
    private Collection<EmailUserCustomerTransactionDetails> emailUserCustomerTransactionDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emailCustomerId")
    private Collection<EmailCustomerMappingDetails> emailCustomerMappingDetailsCollection;

    public EmailCustomerDetails() {
    }

    public EmailCustomerDetails(Integer emailCustomerId) {
        this.emailCustomerId = emailCustomerId;
    }

    public Integer getEmailCustomerId() {
        return emailCustomerId;
    }

    public void setEmailCustomerId(Integer emailCustomerId) {
        this.emailCustomerId = emailCustomerId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    @XmlTransient
    public Collection<EmailUserCustomerTransactionDetails> getEmailUserCustomerTransactionDetailsCollection() {
        return emailUserCustomerTransactionDetailsCollection;
    }

    public void setEmailUserCustomerTransactionDetailsCollection(Collection<EmailUserCustomerTransactionDetails> emailUserCustomerTransactionDetailsCollection) {
        this.emailUserCustomerTransactionDetailsCollection = emailUserCustomerTransactionDetailsCollection;
    }

    @XmlTransient
    public Collection<EmailCustomerMappingDetails> getEmailCustomerMappingDetailsCollection() {
        return emailCustomerMappingDetailsCollection;
    }

    public void setEmailCustomerMappingDetailsCollection(Collection<EmailCustomerMappingDetails> emailCustomerMappingDetailsCollection) {
        this.emailCustomerMappingDetailsCollection = emailCustomerMappingDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailCustomerId != null ? emailCustomerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailCustomerDetails)) {
            return false;
        }
        EmailCustomerDetails other = (EmailCustomerDetails) object;
        if ((this.emailCustomerId == null && other.emailCustomerId != null) || (this.emailCustomerId != null && !this.emailCustomerId.equals(other.emailCustomerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tcs.ignite.tcsmail.beans.EmailCustomerDetails[ emailCustomerId=" + emailCustomerId + " ]";
    }
    
}
