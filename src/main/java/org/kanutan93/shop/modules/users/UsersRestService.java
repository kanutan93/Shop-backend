package org.kanutan93.shop.modules.users;

import org.kanutan93.shop.modules.users.models.User;
import org.kanutan93.shop.modules.users.services.UsersService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import java.util.List;

@Path("users")
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class UsersRestService {
    @Inject
    UsersService usersService;

    @GET
    public List<User> getGoods(@QueryParam("search") String filter){
        return usersService.getUsers(filter);
    }

    @POST
    @Path("new")
    @Consumes(MediaType.APPLICATION_JSON)
    public User createGoods(User good) throws IllegalAccessException, NoSuchFieldException {
        return usersService.createUser(good);
    }

    @PUT
    @Path("update")
    public User updateGoods(User good) throws IllegalAccessException, NoSuchFieldException {
        return usersService.updateUser(good);
    }

    @DELETE
    @Path("delete/{name}")
    public void deleteGoods(@PathParam("name") String name){
        usersService.deleteUser(name);
    }
}
