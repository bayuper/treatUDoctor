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
@Table(name = "room")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r"),
    @NamedQuery(name = "Room.findByIdRoom", query = "SELECT r FROM Room r WHERE r.idRoom = :idRoom"),
    @NamedQuery(name = "Room.findByCapacityRoom", query = "SELECT r FROM Room r WHERE r.capacityRoom = :capacityRoom"),
    @NamedQuery(name = "Room.findByUrlRoom", query = "SELECT r FROM Room r WHERE r.urlRoom = :urlRoom")})
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_room")
    private Integer idRoom;
    @Column(name = "capacity_room")
    private Integer capacityRoom;
    @Column(name = "url_room")
    private String urlRoom;
    
    @JsonIgnore
    @OneToMany(mappedBy = "idRoom")
    private Collection<Consultation> consultationCollection;

    public Room() {
    }

    public Room(Integer idRoom) {
        this.idRoom = idRoom;
    }

    public Integer getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Integer idRoom) {
        this.idRoom = idRoom;
    }

    public Integer getCapacityRoom() {
        return capacityRoom;
    }

    public void setCapacityRoom(Integer capacityRoom) {
        this.capacityRoom = capacityRoom;
    }

    public String getUrlRoom() {
        return urlRoom;
    }

    public void setUrlRoom(String urlRoom) {
        this.urlRoom = urlRoom;
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
        hash += (idRoom != null ? idRoom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Room)) {
            return false;
        }
        Room other = (Room) object;
        if ((this.idRoom == null && other.idRoom != null) || (this.idRoom != null && !this.idRoom.equals(other.idRoom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.TreatU.treatUDoctor.entity.Room[ idRoom=" + idRoom + " ]";
    }
    
}
