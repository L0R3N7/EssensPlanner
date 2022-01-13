package me.api;

import me.models.PersonDTO;
import me.models.mapper.Mappings;
import me.workloads.person.Person;
import me.workloads.person.logic.PersonService;

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
    @Path("signin")
    @Transactional
    public Response addUser(
        PersonDTO newUser
    ){
        System.out.println("New User: "+newUser.getEmail()+" is signing in");
        return Response.ok(
                Mappings.INSTANCE.personToPersonDTO(
                        this.personService.addPerson(newUser.getEmail(), newUser.getPassword()))
                ).build();
    }

    @POST
    @Path("login")
    @Transactional
    public Response validateUser(
            PersonDTO personDTO
    ){
        System.out.println("User: "+personDTO.getEmail()+" is trying to log in");
        Person person = this.personService.validateUser(personDTO);
        return ((person != null)?
                Response.ok(Mappings.INSTANCE.personToPersonDTO(person)):Response.status(404)).build();
    }

}
