/*
 * CST8218 Assignment 1
 * Author: Lucas Estienne <esti0011@algonquinlive.com>
 * 2020W Term
 */
package cst8218.esti0011.service;

import cst8218.esti0011.entity.Sprite;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Facade for our REST service. Extends AbstractFacade.
 * Sets our persistence context and defines our endpoints.
 * @author lucas.estienne
 * @version 1.0
 * @since 1.0
 */
@Stateless
@Path("cst8218.esti0011.entity.sprite")
public class SpriteFacadeREST extends AbstractFacade<Sprite> {

    @PersistenceContext(unitName = "SpriteLucas-ejbPU")
    private EntityManager em;

    public SpriteFacadeREST() {
        super(Sprite.class);
    }

    /** REST Method to create a Sprite.
     * POST <base-url>/resources/cst8218.esti0011.entity.sprite
     * @param entity The Sprite to create
     */
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Sprite entity) {
        super.create(entity);
    }

    /** REST Method to update a Sprite.
     * PUT <base-url>/resources/cst8218.esti0011.entity.sprite/<id>
     * @param id The ID of the Sprite to update
     * @param entity The updated Sprite entity
     */
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Sprite entity) {
        super.edit(entity);
    }

    /** REST Method to delete a Sprite.
     * DELETE <base-url>/resources/cst8218.esti0011.entity.sprite/<id>
     * @param id The ID of the Sprite to delete
     */
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }
    
    /** REST Method to get a Sprite by ID.
     * GET <base-url>/resources/cst8218.esti0011.entity.sprite/<id>
     * @param id The ID of the Sprite to get
     * @return A Sprite object matching the ID.
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Sprite find(@PathParam("id") Long id) {
        return super.find(id);
    }

    /** REST Method to get a list of all Sprites.
     * GET <base-url>/resources/cst8218.esti0011.entity.sprite
     * @return a List of all Sprite objects
     */
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Sprite> findAll() {
        return super.findAll();
    }

    /** REST Method to get a list of Sprites in a range of IDs
     * GET <base-url>/resources/cst8218.esti0011.entity.sprite/<from>/<to>
     * @param from The first ID in the range of Sprites
     * @param to The last ID in the range of Sprites
     * @return a List of Sprite objects matching the range of IDs provided
     */
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Sprite> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    /** REST Method to get the count of Sprites
     * GET <base-url>/resources/cst8218.esti0011.entity.sprite/count
     * @return a String representing the count of Sprites
     */
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
