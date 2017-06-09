/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "pasante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pasante.findAll", query = "SELECT p FROM Pasante p")
    , @NamedQuery(name = "Pasante.findByIdPasante", query = "SELECT p FROM Pasante p WHERE p.idPasante = :idPasante")
    , @NamedQuery(name = "Pasante.findByNombre", query = "SELECT p FROM Pasante p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Pasante.findByApellido", query = "SELECT p FROM Pasante p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "Pasante.findByCedula", query = "SELECT p FROM Pasante p WHERE p.cedula = :cedula")
    , @NamedQuery(name = "Pasante.findByEdad", query = "SELECT p FROM Pasante p WHERE p.edad = :edad")
    , @NamedQuery(name = "Pasante.findByEliminado", query = "SELECT p FROM Pasante p WHERE p.eliminado = :eliminado")
    , @NamedQuery(name = "Pasante.findByFechaRegistro", query = "SELECT p FROM Pasante p WHERE p.fechaRegistro = :fechaRegistro")})
public class Pasante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pasante")
    private Integer idPasante;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "apellido")
    private String apellido;
    @Size(max = 45)
    @Column(name = "cedula")
    private String cedula;
    @Column(name = "edad")
    private Integer edad;
    @Column(name = "eliminado")
    private Boolean eliminado;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @JoinColumn(name = "id_carrera", referencedColumnName = "id_carrera")
    @ManyToOne
    private Carrera idCarrera;
    @JoinColumn(name = "id_pasantia", referencedColumnName = "id_pasantia")
    @ManyToOne
    private Pasantia idPasantia;

    public Pasante() {
    }

    public Pasante(String nombre, String apellido, String cedula, Integer edad, Boolean eliminado, Date fechaRegistro, Carrera idCarrera, Pasantia idPasantia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.edad = edad;
        this.eliminado = eliminado;
        this.fechaRegistro = fechaRegistro;
        this.idCarrera = idCarrera;
        this.idPasantia = idPasantia;
    }

    
    
    

    public Pasante(Integer idPasante) {
        this.idPasante = idPasante;
    }

    public Integer getIdPasante() {
        return idPasante;
    }

    public void setIdPasante(Integer idPasante) {
        this.idPasante = idPasante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
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

    public Carrera getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Carrera idCarrera) {
        this.idCarrera = idCarrera;
    }

    public Pasantia getIdPasantia() {
        return idPasantia;
    }

    public void setIdPasantia(Pasantia idPasantia) {
        this.idPasantia = idPasantia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPasante != null ? idPasante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pasante)) {
            return false;
        }
        Pasante other = (Pasante) object;
        if ((this.idPasante == null && other.idPasante != null) || (this.idPasante != null && !this.idPasante.equals(other.idPasante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Pasante[ idPasante=" + idPasante + " ]";
    }
    
}
