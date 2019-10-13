/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.ignite.tcsmail.beans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sabhis231
 */
@Entity
@Table(name = "email_user_customer_transaction_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmailUserCustomerTransactionDetails.findAll", query = "SELECT e FROM EmailUserCustomerTransactionDetails e")})
public class EmailUserCustomerTransactionDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "transaction_id")
    private Integer transactionId;
    @Lob
    @Size(max = 65535)
    @Column(name = "created")
    private String created;
    @Lob
    @Size(max = 65535)
    @Column(name = "tr_from")
    private String trFrom;
    @Lob
    @Size(max = 65535)
    @Column(name = "tr_to")
    private String trTo;
    @Lob
    @Size(max = 65535)
    @Column(name = "tr_cc")
    private String trCc;
    @Lob
    @Size(max = 65535)
    @Column(name = "tr_subject")
    private String trSubject;
    @Lob
    @Size(max = 65535)
    @Column(name = "tr_content")
    private String trContent;
    @Lob
    @Size(max = 65535)
    @Column(name = "last_modified")
    private String lastModified;
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
    @OneToMany(mappedBy = "emailTransactionId")
    private Collection<EmailStatusDetails> emailStatusDetailsCollection;

    public EmailUserCustomerTransactionDetails() {
    }

    public EmailUserCustomerTransactionDetails(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getTrFrom() {
        return trFrom;
    }

    public void setTrFrom(String trFrom) {
        this.trFrom = trFrom;
    }

    public String getTrTo() {
        return trTo;
    }

    public void setTrTo(String trTo) {
        this.trTo = trTo;
    }

    public String getTrCc() {
        return trCc;
    }

    public void setTrCc(String trCc) {
        this.trCc = trCc;
    }

    public String getTrSubject() {
        return trSubject;
    }

    public void setTrSubject(String trSubject) {
        this.trSubject = trSubject;
    }

    public String getTrContent() {
        return trContent;
    }

    public void setTrContent(String trContent) {
        this.trContent = trContent;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
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

    @XmlTransient
    public Collection<EmailStatusDetails> getEmailStatusDetailsCollection() {
        return emailStatusDetailsCollection;
    }

    public void setEmailStatusDetailsCollection(Collection<EmailStatusDetails> emailStatusDetailsCollection) {
        this.emailStatusDetailsCollection = emailStatusDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionId != null ? transactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailUserCustomerTransactionDetails)) {
            return false;
        }
        EmailUserCustomerTransactionDetails other = (EmailUserCustomerTransactionDetails) object;
        if ((this.transactionId == null && other.transactionId != null) || (this.transactionId != null && !this.transactionId.equals(other.transactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tcs.ignite.tcsmail.beans.EmailUserCustomerTransactionDetails[ transactionId=" + transactionId + " ]";
    }
    
}
