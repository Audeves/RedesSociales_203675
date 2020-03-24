/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.RedSocial;
import entity.Usuario;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Invitado
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("RedesSociales_203675PU");
        EntityManager entityManager  = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Usuario user = new Usuario();
        user.setNombre("Luis Audeves");
        user.setEmail("audeves01@gmail.com");
        user.setFechaNac(new Date());
        user.setSexo(true);

        entityManager.persist(user);

        RedSocial redSocial1 = new RedSocial();
        redSocial1.setFechaInicio(new Date());
        redSocial1.setNombre("GMAIL");
        redSocial1.setWebsite("GMAIL.com");
        redSocial1.agregarUsuario(user, "Audeves");

        entityManager.persist(redSocial1);

        entityManager.getTransaction().commit();

    }

}
