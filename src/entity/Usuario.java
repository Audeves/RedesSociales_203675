/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
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
public class Usuario extends EntityBase implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    public Usuario() {
        this.redes=new HashSet<RedSocialUsuario>();
    }

    @Column
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column
    private boolean sexo;

    public boolean getSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNacimiento;

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNac) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Set<RedSocialUsuario> redes = new HashSet<>();

    public Set<RedSocialUsuario> getRedes() {
        return redes;
    }

    public void addRed(RedSocialUsuario red) {
        this.redes.add(red);
    }

    public int getEdad() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(this.fechaNacimiento.toString(), fmt);
        LocalDate ahora = LocalDate.now();
        return Period.between(fechaNac, ahora).getYears();
    }

    @Override
    public String toString() {
        return "entity.Usuario[ id=" + id + " ]";
    }

}
