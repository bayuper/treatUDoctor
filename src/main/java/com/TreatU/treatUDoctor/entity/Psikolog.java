/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TreatU.treatUDoctor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author innovative
 */
@Entity
@Table(name = "psikolog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Psikolog.findAll", query = "SELECT p FROM Psikolog p"),
    @NamedQuery(name = "Psikolog.findById", query = "SELECT p FROM Psikolog p WHERE p.id = :id"),
    @NamedQuery(name = "Psikolog.findByName", query = "SELECT p FROM Psikolog p WHERE p.name = :name"),
    @NamedQuery(name = "Psikolog.findByEmail", query = "SELECT p FROM Psikolog p WHERE p.email = :email"),
    @NamedQuery(name = "Psikolog.findByIsActive", query = "SELECT p FROM Psikolog p WHERE p.isActive = :isActive")})
public class Psikolog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "is_active")
    private boolean isActive;
    
    @JsonIgnore
    @OneToMany(mappedBy = "idPsikolog")
    private Collection<Consultation> consultationCollection;

    public Psikolog() {
    }

    public Psikolog(Integer id) {
        this.id = id;
    }

    public Psikolog(Integer id, String name, String email, boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public Collection<Consultation> getConsultationCollection() {
        return consultationCollection;
    }

    public void setConsultationCollection(Collection<Consultation> consultationCollection) {
        this.consultationCollection = consultationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Psikolog)) {
            return false;
        }
        Psikolog other = (Psikolog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.TreatU.treatUDoctor.entity.Psikolog[ id=" + id + " ]";
    }
    
}
