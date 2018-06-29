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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bastianjoe
 */
@Entity
@Table(name = "cmn_user_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmnUserDetails.findAll", query = "SELECT c FROM CmnUserDetails c")})
public class CmnUserDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "user_name")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    @Column(name = "last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_deleted")
    private boolean isDeleted;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_visible")
    private boolean isVisible;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "keyword")
    private String keyword;
    @Lob
    @Size(max = 65535)
    @Column(name = "image_path")
    private String imagePath;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "primary_email")
    private String primaryEmail;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne(optional = false)
    private MasterRole roleId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<EmailUserCustomerTransactionDetails> emailUserCustomerTransactionDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<EmailCustomerMappingDetails> emailCustomerMappingDetailsCollection;

    public CmnUserDetails() {
    }

    public CmnUserDetails(Integer userId) {
        this.userId = userId;
    }

    public CmnUserDetails(Integer userId, String userName, String password, boolean isDeleted, boolean isVisible, String keyword, String gender, String primaryEmail) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.isDeleted = isDeleted;
        this.isVisible = isVisible;
        this.keyword = keyword;
        this.gender = gender;
        this.primaryEmail = primaryEmail;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public boolean getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    public MasterRole getRoleId() {
        return roleId;
    }

    public void setRoleId(MasterRole roleId) {
        this.roleId = roleId;
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
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CmnUserDetails)) {
            return false;
        }
        CmnUserDetails other = (CmnUserDetails) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tcs.ignite.tcsmail.beans.CmnUserDetails[ userId=" + userId + " ]";
    }
    
}
