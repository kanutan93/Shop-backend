package org.kanutan93.shop.modules.goods.services;

import org.kanutan93.shop.modules.goods.models.Good;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import java.util.List;

@Path("good")
@Provider
@Produces(MediaType.APPLICATION_JSON)
public interface GoodsService {
    /**
     * Get goods by search with params for pagination
     * @param filter Filter (if filter == null, find all)
     * @param page Number page (for pagination)
     * @return Result goods
     */
    @GET
    List<Good> getGoods(@QueryParam("search") String filter, @QueryParam("page") int page);

    /**
     * Create good
     * @param good (JSON map to Good)
     * @return Created good
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @POST
    @Path("new")
    Good createGood(Good good) throws NoSuchFieldException, IllegalAccessException;

    /**
     * Updated good
     * @param good JSON (map to Good)
     * @return Updated good
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @PUT
    @Path("update")
    Good updateGood(Good good) throws NoSuchFieldException, IllegalAccessException;


    /**
     * Delete good
     * @param name good name
     */
    @DELETE
    @Path("{name}/delete")
    void deleteGood(@PathParam("name") String name);
}
