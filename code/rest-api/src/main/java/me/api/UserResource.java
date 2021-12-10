package me.api;

import me.models.UserDTO;
import me.workloads.user.UserService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    private UserService userService;

    @POST
    @Transactional
    public Response addUser(
        UserDTO newUser
    ){

        this.userService.addUser(newUser);
    }

    @POST
    @Path("login")
    public Response validateUser)(
            UserDTO validUser
            ){
        User u =

    }
}
