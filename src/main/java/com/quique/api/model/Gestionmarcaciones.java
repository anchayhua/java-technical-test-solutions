/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quique.api.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nanchayhua
 */
@Entity
@Table(name = "GESTIONMARCACIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gestionmarcaciones.findAll", query = "SELECT g FROM Gestionmarcaciones g")
    , @NamedQuery(name = "Gestionmarcaciones.findByMarcIdMarcaciones", query = "SELECT g FROM Gestionmarcaciones g WHERE g.marcIdMarcaciones = :marcIdMarcaciones")
    , @NamedQuery(name = "Gestionmarcaciones.findByMarcEmpleado", query = "SELECT g FROM Gestionmarcaciones g WHERE g.marcEmpleado = :marcEmpleado")
    , @NamedQuery(name = "Gestionmarcaciones.findByMarcFecha", query = "SELECT g FROM Gestionmarcaciones g WHERE g.marcFecha = :marcFecha")
    , @NamedQuery(name = "Gestionmarcaciones.findByMarcIpMarcador", query = "SELECT g FROM Gestionmarcaciones g WHERE g.marcIpMarcador = :marcIpMarcador")
    , @NamedQuery(name = "Gestionmarcaciones.findByMarcprocesado", query = "SELECT g FROM Gestionmarcaciones g WHERE g.marcprocesado = :marcprocesado")
    , @NamedQuery(name = "Gestionmarcaciones.findByDtProcesamiento", query = "SELECT g FROM Gestionmarcaciones g WHERE g.dtProcesamiento = :dtProcesamiento")})
public class Gestionmarcaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Marc_IdMarcaciones")
    private Long marcIdMarcaciones;
    @Size(max = 10)
    @Column(name = "Marc_Empleado")
    private String marcEmpleado;
    @Column(name = "Marc_Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date marcFecha;
    @Size(max = 15)
    @Column(name = "Marc_IpMarcador")
    private String marcIpMarcador;
    @Column(name = "Marc_procesado")
    private Short marcprocesado;
    @Column(name = "dtProcesamiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtProcesamiento;

    public Gestionmarcaciones() {
    }

    public Gestionmarcaciones(Long marcIdMarcaciones) {
        this.marcIdMarcaciones = marcIdMarcaciones;
    }

    public Long getMarcIdMarcaciones() {
        return marcIdMarcaciones;
    }

    public void setMarcIdMarcaciones(Long marcIdMarcaciones) {
        this.marcIdMarcaciones = marcIdMarcaciones;
    }

    public String getMarcEmpleado() {
        return marcEmpleado;
    }

    public void setMarcEmpleado(String marcEmpleado) {
        this.marcEmpleado = marcEmpleado;
    }

    public Date getMarcFecha() {
        return marcFecha;
    }

    public void setMarcFecha(Date marcFecha) {
        this.marcFecha = marcFecha;
    }

    public String getMarcIpMarcador() {
        return marcIpMarcador;
    }

    public void setMarcIpMarcador(String marcIpMarcador) {
        this.marcIpMarcador = marcIpMarcador;
    }

    public Short getMarcprocesado() {
        return marcprocesado;
    }

    public void setMarcprocesado(Short marcprocesado) {
        this.marcprocesado = marcprocesado;
    }

    public Date getDtProcesamiento() {
        return dtProcesamiento;
    }

    public void setDtProcesamiento(Date dtProcesamiento) {
        this.dtProcesamiento = dtProcesamiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (marcIdMarcaciones != null ? marcIdMarcaciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gestionmarcaciones)) {
            return false;
        }
        Gestionmarcaciones other = (Gestionmarcaciones) object;
        if ((this.marcIdMarcaciones == null && other.marcIdMarcaciones != null) || (this.marcIdMarcaciones != null && !this.marcIdMarcaciones.equals(other.marcIdMarcaciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pnsu.jpa.sqlserverlocal.Gestionmarcaciones[ marcIdMarcaciones=" + marcIdMarcaciones + " ]";
    }

}
