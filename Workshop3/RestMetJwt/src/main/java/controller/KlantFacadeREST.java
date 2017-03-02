/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.KlantFacade;
import pojo.Klant;

/**
 *
 * @author Ian
 */
@Stateless
@Path("klant")
public class KlantFacadeREST{

    @Inject
    private KlantFacade klantDao;

    public KlantFacadeREST() {
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Klant entity) {
        klantDao.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Klant entity) {
        entity.setId(id);
        klantDao.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        klantDao.remove(klantDao.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Klant find(@PathParam("id") Integer id) {
        return klantDao.find(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Klant> findAll() {
        return klantDao.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Klant> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to){
        int[] range = {from, to};
        return klantDao.findRange(range);
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countREST() {
        return klantDao.count();
    }
    
}
