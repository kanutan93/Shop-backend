package org.kanutan93.shop.modules.goods;

import org.kanutan93.shop.modules.goods.models.Good;
import org.kanutan93.shop.modules.goods.services.GoodsService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import java.util.List;


@Path("goods")
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class GoodsRestService {
    @Inject
    private GoodsService goodsService;

    @GET
    public List<Good> getGoods(@QueryParam("search") String filter, @QueryParam("page") int page){
        return goodsService.getGoods(filter, page);
    }

    @POST
    @Path("new")
    public Good createGoods(Good good) throws NoSuchFieldException, IllegalAccessException {
        return goodsService.createGood(good);
    }

    @PUT
    @Path("update")
    public Good updateGoods(Good good) throws NoSuchFieldException, IllegalAccessException {
        return goodsService.updateGood(good);
    }

    @DELETE
    @Path("delete/{name}")
    public void deleteGoods(@PathParam("name") String name){
        goodsService.deleteGood(name);
    }
}
