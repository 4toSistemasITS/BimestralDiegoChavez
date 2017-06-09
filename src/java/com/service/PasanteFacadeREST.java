/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.Carrera;
import com.model.Pasante;
import com.model.Pasantia;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
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
@Path("com.model.pasante")
public class PasanteFacadeREST extends AbstractFacade<Pasante> {
    
    @EJB
    PasantiaFacadeREST pasantiaFacadeREST;
    @EJB
    CarreraFacadeREST carreraFacadeREST;

    @PersistenceContext(unitName = "BimestralPU")
    private EntityManager em;

    public PasanteFacadeREST() {
        super(Pasante.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Pasante entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Pasante entity) {
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
    public Pasante find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Pasante> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Pasante> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    public String crear(@FormParam("nombre")String nombre,@FormParam("apellido")String apellido,@FormParam("cedula")String cedula,@FormParam("edad")int edad,@FormParam("id_pasantia")int id_pasantia,@FormParam("id_carrera")int id_carrera){
        String mensaje="{\"exitoso\":false}";
        Pasantia p=pasantiaFacadeREST.find(id_pasantia);
        Carrera c=carreraFacadeREST.find(id_carrera);
        
        try{
            if (crear1(cedula)==null){
                create(new Pasante(nombre,apellido,cedula,edad, false,new Date(),c,p));
                mensaje="{\"exitoso\":true}";
            } 
        }catch(Exception ex){      
        }
        return mensaje;
    }
    
    @POST
    @Path("Leer")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Pasante> leer() {
        return super.findAll();
    }
    
    @POST
    @Path("consultarPorNombre")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Pasante> consultarValidos(@FormParam("nombre")String nombre) {
        List<Pasante> retorno=obtenerPorNombre(nombre);
        return retorno;
    }
    
    @POST
    @Path("editar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String editar(@FormParam("id_pasante")int id_pasante,@FormParam("nombre")String nombre,@FormParam("apellido")String apellido,@FormParam("edad")int edad){
        String mensaje="{\"exitoso\":false,\"motivo\":";
        Pasante ps=BuscarPorId(id_pasante);
        if (ps!=null){
            if (!(nombre.equals("")||apellido.equals("")||edad==0 )){
               ps.setNombre(nombre);
               ps.setApellido(apellido);
               ps.setEdad(edad);
               ps.setFechaRegistro(new Date());

               
                try{
                    edit(ps);
                    mensaje="{\"exitoso\":true";
                }catch(Exception ex){
                    mensaje+="\"Excepcion en base\"";
                } 
            }else{
                mensaje+="\"No se ingreso datos validos\"";
            }
              
        }else{
            mensaje+="\"Datos no correctos\"";
        }
        
        mensaje+="}";
        return mensaje;
    }
    
    @POST
    @Path("eliminar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String eliminar(@FormParam ("id_pasante")int id_pasante){
        String mensaje="{\"exitoso\":false,\"motivo\":";
        Pasante ps=BuscarPorId(id_pasante);
        if (ps!=null){
            ps.setEliminado(true);
            edit(ps);
            mensaje="{\"exitoso\":true";
        }else{
            mensaje+="\"Datos no correctos\"";
        }
        
        mensaje+="}";
        return mensaje;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public Pasante crear1(String cedula){
        Pasante e= null;
        TypedQuery<Pasante>qry;
        qry=getEntityManager().createQuery("SELECT p FROM Pasante p WHERE p.cedula = :cedula", Pasante.class);
        qry.setParameter("cedula", cedula);
        try {
            return qry.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    List<Pasante>obtenerPorNombre(String Nombre){
        TypedQuery<Pasante> qry;
        qry=getEntityManager().createQuery("SELECT p FROM Pasante p WHERE p.nombre = :nombre", Pasante.class);
        qry.setParameter("nombre", Nombre);
        try{
            return qry.getResultList();
        }catch(NoResultException e){
            return null;
        }
        
    }
    
    public Pasante BuscarPorId(int idPasante){
        TypedQuery<Pasante>qry;
        qry=getEntityManager().createQuery("SELECT p FROM Pasante p WHERE p.idPasante = :idPasante and p.eliminado = :eliminado", Pasante.class);
        qry.setParameter("idPasante", idPasante);
        qry.setParameter("eliminado", false);
        try {
            return qry.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
}
