/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.ignite.tcsmail.beans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bastianjoe
 */
@Entity
@Table(name = "master_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MasterRole.findAll", query = "SELECT m FROM MasterRole m")})
public class MasterRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "role_id")
    private Integer roleId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_deleted")
    private short isDeleted;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "role")
    private String role;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleId")
    private Collection<CmnUserDetails> cmnUserDetailsCollection;

    public MasterRole() {
    }

    public MasterRole(Integer roleId) {
        this.roleId = roleId;
    }

    public MasterRole(Integer roleId, short isDeleted, String role) {
        this.roleId = roleId;
        this.isDeleted = isDeleted;
        this.role = role;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public short getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(short isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @XmlTransient
    public Collection<CmnUserDetails> getCmnUserDetailsCollection() {
        return cmnUserDetailsCollection;
    }

    public void setCmnUserDetailsCollection(Collection<CmnUserDetails> cmnUserDetailsCollection) {
        this.cmnUserDetailsCollection = cmnUserDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MasterRole)) {
            return false;
        }
        MasterRole other = (MasterRole) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tcs.ignite.tcsmail.beans.MasterRole[ roleId=" + roleId + " ]";
    }
    
}
