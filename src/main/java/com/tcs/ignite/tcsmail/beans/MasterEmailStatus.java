/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.ignite.tcsmail.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bastianjoe
 */
@Entity
@Table(name = "master_email_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MasterEmailStatus.findAll", query = "SELECT m FROM MasterEmailStatus m")})
public class MasterEmailStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "email_status_id")
    private Integer emailStatusId;
    @Lob
    @Size(max = 65535)
    @Column(name = "status_name")
    private String statusName;
    @Column(name = "is_deleted")
    private Boolean isDeleted;
    @Column(name = "is_visible")
    private Boolean isVisible;

    public MasterEmailStatus() {
    }

    public MasterEmailStatus(Integer emailStatusId) {
        this.emailStatusId = emailStatusId;
    }

    public Integer getEmailStatusId() {
        return emailStatusId;
    }

    public void setEmailStatusId(Integer emailStatusId) {
        this.emailStatusId = emailStatusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailStatusId != null ? emailStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MasterEmailStatus)) {
            return false;
        }
        MasterEmailStatus other = (MasterEmailStatus) object;
        if ((this.emailStatusId == null && other.emailStatusId != null) || (this.emailStatusId != null && !this.emailStatusId.equals(other.emailStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tcs.ignite.tcsmail.beans.MasterEmailStatus[ emailStatusId=" + emailStatusId + " ]";
    }
    
}
