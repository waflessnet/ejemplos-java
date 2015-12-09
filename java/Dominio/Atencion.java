/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import Dominio.Cliente;
import Dominio.Servicio;
import Dominio.Modulo;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "atencion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Atencion.findAll", query = "SELECT a FROM Atencion a"),
    @NamedQuery(name = "Atencion.findByNroAtencion", query = "SELECT a FROM Atencion a WHERE a.nroAtencion = :nroAtencion"),
    @NamedQuery(name = "Atencion.findByEsCliente", query = "SELECT a FROM Atencion a WHERE a.esCliente = :esCliente"),
    @NamedQuery(name = "Atencion.findByTiempoEspera", query = "SELECT a FROM Atencion a WHERE a.tiempoEspera = :tiempoEspera"),
    @NamedQuery(name = "Atencion.findByComentario", query = "SELECT a FROM Atencion a WHERE a.comentario = :comentario"),
    @NamedQuery(name = "Atencion.findByFechaCreacion", query = "SELECT a FROM Atencion a WHERE a.fechaCreacion = :fechaCreacion")})
public class Atencion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nro_atencion")
    private Integer nroAtencion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "es_cliente")
    private boolean esCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiempo_espera")
    private int tiempoEspera;
    @Size(max = 250)
    @Column(name = "comentario")
    private String comentario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
    @ManyToOne(optional = false)
    private Servicio idServicio;
    @JoinColumn(name = "nro_modulo", referencedColumnName = "nro_modulo")
    @ManyToOne(optional = false)
    private Modulo nroModulo;
    @JoinColumn(name = "rut", referencedColumnName = "rut")
    @ManyToOne(optional = false)
    private Cliente rut;

    public Atencion() {
    }

    public Atencion(Integer nroAtencion) {
        this.nroAtencion = nroAtencion;
    }

    public Atencion(Integer nroAtencion, boolean esCliente, int tiempoEspera,Integer _rut,String Comentario) {
        Cliente c  =new Cliente(_rut);
        Servicio s = new Servicio(1);
        Modulo m = new Modulo(1);
        this.rut = c; 
        this.idServicio =s;
        this.nroModulo = m;
        this.nroAtencion = nroAtencion;
        this.esCliente = esCliente;
        this.tiempoEspera = tiempoEspera;
        this.comentario = Comentario;
        //this.fechaCreacion = fechaCreacion;
    }

    public Integer getNroAtencion() {
        return nroAtencion;
    }

    public void setNroAtencion(Integer nroAtencion) {
        this.nroAtencion = nroAtencion;
    }

    public boolean getEsCliente() {
        return esCliente;
    }

    public void setEsCliente(boolean esCliente) {
        this.esCliente = esCliente;
    }

    public int getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(int tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    public Modulo getNroModulo() {
        return nroModulo;
    }

    public void setNroModulo(Modulo nroModulo) {
        this.nroModulo = nroModulo;
    }

    public Cliente getRut() {
        return rut;
    }

    public void setRut(Cliente rut) {
        this.rut = rut;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroAtencion != null ? nroAtencion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atencion)) {
            return false;
        }
        Atencion other = (Atencion) object;
        if ((this.nroAtencion == null && other.nroAtencion != null) || (this.nroAtencion != null && !this.nroAtencion.equals(other.nroAtencion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominio.Atencion[ nroAtencion=" + nroAtencion + " ]";
    }
    
}
