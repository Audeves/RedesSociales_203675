/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Luis
 */
@Entity
public class RedSocial extends EntityBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column
    private String nombre;

    public RedSocial() {
        this.usuarios=new HashSet<RedUsuario>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column
    private String website;

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
    public void agregarUsuario(Usuario usuario, String pseudonimo){
        RedUsuario red=new RedUsuario(usuario, this, new Date(), pseudonimo);
        usuario.addRed(red);
        this.usuarios.add(red);
    }
    
    @OneToMany(mappedBy="redSocial", cascade=CascadeType.ALL)
    private Set<RedUsuario> usuarios;

    public RedSocial(String nombre, String website, Date fechaInicio, Set<RedUsuario> usuarios) {
        this.nombre = nombre;
        this.website = website;
        this.fechaInicio = fechaInicio;
        this.usuarios = usuarios;
    }
    
    

    @Override
    public String toString() {
        return "entity.RedSocial[ id=" + id + " ]";
    }

}
