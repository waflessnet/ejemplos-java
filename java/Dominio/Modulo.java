/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "modulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modulo.findAll", query = "SELECT m FROM Modulo m"),
    @NamedQuery(name = "Modulo.findByNroModulo", query = "SELECT m FROM Modulo m WHERE m.nroModulo = :nroModulo"),
    @NamedQuery(name = "Modulo.findByCargaActual", query = "SELECT m FROM Modulo m WHERE m.cargaActual = :cargaActual")})
public class Modulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_modulo")
    private Integer nroModulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "carga_actual")
    private int cargaActual;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nroModulo")
    private List<Atencion> atencionList;

    public Modulo() {
    }

    public Modulo(Integer nroModulo) {
        this.nroModulo = nroModulo;
    }

    public Modulo(Integer nroModulo, int cargaActual) {
        this.nroModulo = nroModulo;
        this.cargaActual = cargaActual;
    }

    public Integer getNroModulo() {
        return nroModulo;
    }

    public void setNroModulo(Integer nroModulo) {
        this.nroModulo = nroModulo;
    }

    public int getCargaActual() {
        return cargaActual;
    }

    public void setCargaActual(int cargaActual) {
        this.cargaActual = cargaActual;
    }

    @XmlTransient
    public List<Atencion> getAtencionList() {
        return atencionList;
    }

    public void setAtencionList(List<Atencion> atencionList) {
        this.atencionList = atencionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroModulo != null ? nroModulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modulo)) {
            return false;
        }
        Modulo other = (Modulo) object;
        if ((this.nroModulo == null && other.nroModulo != null) || (this.nroModulo != null && !this.nroModulo.equals(other.nroModulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominio.Modulo[ nroModulo=" + nroModulo + " ]";
    }
    
}
