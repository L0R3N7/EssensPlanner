package me.api;

import me.models.PersonDTO;
import me.workloads.user.PersonService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("person")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    @Inject
    private PersonService personService;

    @POST
    @Transactional
    public Response addUser(
        PersonDTO newUser
    ){
        System.out.println("add User");
        return Response.ok(
                this.personService.addPerson(newUser.getEmail(),
                        newUser.getPassword())).build();
    }

    /*@POST
    @Path("login")
    public Response validateUser)(
            UserDTO validUser
            ){
        User u =
    }*/
}
