/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "pasantia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pasantia.findAll", query = "SELECT p FROM Pasantia p")
    , @NamedQuery(name = "Pasantia.findByIdPasantia", query = "SELECT p FROM Pasantia p WHERE p.idPasantia = :idPasantia")
    , @NamedQuery(name = "Pasantia.findByNombrePasantia", query = "SELECT p FROM Pasantia p WHERE p.nombrePasantia = :nombrePasantia")
    , @NamedQuery(name = "Pasantia.findByNumeroHoras", query = "SELECT p FROM Pasantia p WHERE p.numeroHoras = :numeroHoras")
    , @NamedQuery(name = "Pasantia.findByEliminado", query = "SELECT p FROM Pasantia p WHERE p.eliminado = :eliminado")
    , @NamedQuery(name = "Pasantia.findByFechaRegistro", query = "SELECT p FROM Pasantia p WHERE p.fechaRegistro = :fechaRegistro")})
public class Pasantia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pasantia")
    private Integer idPasantia;
    @Size(max = 45)
    @Column(name = "nombrePasantia")
    private String nombrePasantia;
    @Column(name = "numeroHoras")
    private Integer numeroHoras;
    @Column(name = "eliminado")
    private Boolean eliminado;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @OneToMany(mappedBy = "idPasantia")
    private List<Pasante> pasanteList;

    public Pasantia() {
    }

    public Pasantia(String nombrePasantia, Integer numeroHoras, Boolean eliminado, Date fechaRegistro) {
        this.nombrePasantia = nombrePasantia;
        this.numeroHoras = numeroHoras;
        this.eliminado = eliminado;
        this.fechaRegistro = fechaRegistro;
    }
    
    

    public Pasantia(Integer idPasantia) {
        this.idPasantia = idPasantia;
    }

    public Integer getIdPasantia() {
        return idPasantia;
    }

    public void setIdPasantia(Integer idPasantia) {
        this.idPasantia = idPasantia;
    }

    public String getNombrePasantia() {
        return nombrePasantia;
    }

    public void setNombrePasantia(String nombrePasantia) {
        this.nombrePasantia = nombrePasantia;
    }

    public Integer getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(Integer numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @XmlTransient
    public List<Pasante> getPasanteList() {
        return pasanteList;
    }

    public void setPasanteList(List<Pasante> pasanteList) {
        this.pasanteList = pasanteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPasantia != null ? idPasantia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pasantia)) {
            return false;
        }
        Pasantia other = (Pasantia) object;
        if ((this.idPasantia == null && other.idPasantia != null) || (this.idPasantia != null && !this.idPasantia.equals(other.idPasantia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Pasantia[ idPasantia=" + idPasantia + " ]";
    }
    
}
