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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sabhis231
 */
@Entity
@Table(name = "email_status_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmailStatusDetails.findAll", query = "SELECT e FROM EmailStatusDetails e")})
public class EmailStatusDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "email_status_id")
    private Integer emailStatusId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @Column(name = "is_deleted")
    private Boolean isDeleted;
    @Column(name = "is_visible")
    private Boolean isVisible;
    @JoinColumn(name = "status_id", referencedColumnName = "email_status_id")
    @ManyToOne
    private MasterEmailStatus statusId;
    @JoinColumn(name = "email_transaction_id", referencedColumnName = "transaction_id")
    @ManyToOne
    private EmailUserCustomerTransactionDetails emailTransactionId;

    public EmailStatusDetails() {
    }

    public EmailStatusDetails(Integer emailStatusId) {
        this.emailStatusId = emailStatusId;
    }

    public EmailStatusDetails(Integer emailStatusId, Date created, Date lastModified) {
        this.emailStatusId = emailStatusId;
        this.created = created;
        this.lastModified = lastModified;
    }

    public Integer getEmailStatusId() {
        return emailStatusId;
    }

    public void setEmailStatusId(Integer emailStatusId) {
        this.emailStatusId = emailStatusId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
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

    public MasterEmailStatus getStatusId() {
        return statusId;
    }

    public void setStatusId(MasterEmailStatus statusId) {
        this.statusId = statusId;
    }

    public EmailUserCustomerTransactionDetails getEmailTransactionId() {
        return emailTransactionId;
    }

    public void setEmailTransactionId(EmailUserCustomerTransactionDetails emailTransactionId) {
        this.emailTransactionId = emailTransactionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailStatusId != null ? emailStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailStatusDetails)) {
            return false;
        }
        EmailStatusDetails other = (EmailStatusDetails) object;
        if ((this.emailStatusId == null && other.emailStatusId != null) || (this.emailStatusId != null && !this.emailStatusId.equals(other.emailStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tcs.ignite.tcsmail.beans.EmailStatusDetails[ emailStatusId=" + emailStatusId + " ]";
    }
    
}
