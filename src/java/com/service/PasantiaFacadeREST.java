/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.Pasantia;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author DELL
 */
@Stateless
@Path("com.model.pasantia")
public class PasantiaFacadeREST extends AbstractFacade<Pasantia> {

    @PersistenceContext(unitName = "BimestralPU")
    private EntityManager em;

    public PasantiaFacadeREST() {
        super(Pasantia.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Pasantia entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Pasantia entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Pasantia find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Pasantia> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Pasantia> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @POST
    @Path("Crear")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String crear(@FormParam("nombrePasantia")String nombrePasantia,@FormParam("numero_horas")int numero_horas){
        String mensaje="{\"exitoso\":false}";
        try{
            if (crear1(nombrePasantia)==null){
                create(new Pasantia(nombrePasantia,numero_horas, false,new Date()));
                mensaje="{\"exitoso\":true}";
            } 
        }catch(Exception ex){      
        }
        return mensaje;
    }
    
    @POST
    @Path("Leer")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Pasantia> leer() {
        return super.findAll();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public Pasantia crear1(String nombrePasantia){
        Pasantia e= null;
        TypedQuery<Pasantia>qry;
        qry=getEntityManager().createQuery("SELECT p FROM Pasantia p WHERE p.nombrePasantia = :nombrePasantia", Pasantia.class);
        qry.setParameter("nombrePasantia", nombrePasantia);
        try {
            return qry.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
}
