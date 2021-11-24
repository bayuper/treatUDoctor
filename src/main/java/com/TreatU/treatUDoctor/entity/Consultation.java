/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TreatU.treatUDoctor.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author innovative
 */
@Entity
@Table(name = "consultation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultation.findAll", query = "SELECT c FROM Consultation c"),
    @NamedQuery(name = "Consultation.findById", query = "SELECT c FROM Consultation c WHERE c.id = :id"),
    @NamedQuery(name = "Consultation.findByDate", query = "SELECT c FROM Consultation c WHERE c.date = :date"),
    @NamedQuery(name = "Consultation.findByCreateDate", query = "SELECT c FROM Consultation c WHERE c.createDate = :createDate"),
    @NamedQuery(name = "Consultation.findByUpdateDate", query = "SELECT c FROM Consultation c WHERE c.updateDate = :updateDate"),
    @NamedQuery(name = "Consultation.findByUpdateBy", query = "SELECT c FROM Consultation c WHERE c.updateBy = :updateBy"),
    @NamedQuery(name = "Consultation.findByReportUuid", query = "SELECT c FROM Consultation c WHERE c.reportUuid = :reportUuid")})
public class Consultation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Basic(optional = false)
    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Basic(optional = false)
    @Column(name = "update_by")
    private int updateBy;
    @Lob
    @Column(name = "result")
    private String result;
    @Column(name = "report_uuid")
    private String reportUuid;
    @JoinColumn(name = "id_consultation_status", referencedColumnName = "id_consultation_status")
    @ManyToOne
    private ConsultationStatus idConsultationStatus;
    @JoinColumn(name = "id_session", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Session idSession;
    @JoinColumn(name = "id_employee", referencedColumnName = "id_user")
    @ManyToOne
    private Users idEmployee;
    @JoinColumn(name = "id_room", referencedColumnName = "id_room")
    @ManyToOne
    private Room idRoom;
    @JoinColumn(name = "id_psikolog", referencedColumnName = "id")
    @ManyToOne
    private Psikolog idPsikolog;

    public Consultation() {
    }

    public Consultation(Integer id) {
        this.id = id;
    }

    public Consultation(Integer id, Date createDate, Date updateDate, int updateBy) {
        this.id = id;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.updateBy = updateBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(int updateBy) {
        this.updateBy = updateBy;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getReportUuid() {
        return reportUuid;
    }

    public void setReportUuid(String reportUuid) {
        this.reportUuid = reportUuid;
    }

    public ConsultationStatus getIdConsultationStatus() {
        return idConsultationStatus;
    }

    public void setIdConsultationStatus(ConsultationStatus idConsultationStatus) {
        this.idConsultationStatus = idConsultationStatus;
    }

    public Session getIdSession() {
        return idSession;
    }

    public void setIdSession(Session idSession) {
        this.idSession = idSession;
    }

    public Users getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Users idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Room getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Room idRoom) {
        this.idRoom = idRoom;
    }

    public Psikolog getIdPsikolog() {
        return idPsikolog;
    }

    public void setIdPsikolog(Psikolog idPsikolog) {
        this.idPsikolog = idPsikolog;
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
        if (!(object instanceof Consultation)) {
            return false;
        }
        Consultation other = (Consultation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.TreatU.treatUDoctor.entity.Consultation[ id=" + id + " ]";
    }
    
}
