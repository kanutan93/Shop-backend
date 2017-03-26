package org.kanutan93.shop.modules.users.services;
import org.kanutan93.shop.modules.users.models.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import java.util.List;

@Path("user")
@Provider
@Produces(MediaType.APPLICATION_JSON)
public interface UsersService {
    /**
     * Create User
     * @param item JSON (map to User)
     * @return Created user
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     */
    @POST
    @Path("new")
    @Consumes(MediaType.APPLICATION_JSON)
    User createUser(User item) throws IllegalAccessException, NoSuchFieldException;

    /**
     * Update User
     * @param item JSON (map to User)
     * @return Updated User
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     */
    @PUT
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    User updateUser(User item) throws IllegalAccessException, NoSuchFieldException;

    /**
     * Get users by search
     * @param filter Filter (if filter == null, find all)
     * @return Result users
     */
    @GET
    List<User> getUsers(@QueryParam("search") String filter);

    /**
     * Delete user
     * @param name username
     */
    @DELETE
    @Path("{name}/delete")
    void deleteUser(@PathParam("name") String name);
}
