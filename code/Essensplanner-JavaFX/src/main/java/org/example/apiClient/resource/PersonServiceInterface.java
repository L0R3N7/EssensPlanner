package org.example.apiClient.resource;


import org.example.apiClient.dto.PersonDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("person")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface PersonServiceInterface {

    @POST
    @Path("signin")
    Response addUser(
            PersonDTO newUser
    );

}
