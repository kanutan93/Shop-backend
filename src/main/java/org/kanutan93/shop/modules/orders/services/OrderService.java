package org.kanutan93.shop.modules.orders.services;
import org.kanutan93.shop.modules.orders.models.Order;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

@Path("order")
@Provider
@Produces(MediaType.APPLICATION_JSON)
public interface OrderService {
    @POST
    @Path("new")
    @Consumes(MediaType.APPLICATION_JSON)
    void createOrder(Order item);
}