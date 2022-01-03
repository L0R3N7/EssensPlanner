package me.api;

import me.models.GerichtDTO;
import me.models.mapper.Mappings;
import me.workloads.gerichte.Gericht;
import me.workloads.gerichte.logic.GerichtService;
import me.workloads.person.logic.PersonService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("gericht")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GerichtResource {

    @Inject
    PersonService personService;
    @Inject
    GerichtService gerichtService;

    @GET
    @Path("search/{searchString}")
    public Response search(
            @PathParam("searchString") String searchString
    ){
        List<Gericht> gerichtList = this.gerichtService.search(searchString);
        List<GerichtDTO> gerichtDTOList = gerichtList.stream().map(Mappings.INSTANCE::gerichtToGerichtDTO).collect(Collectors.toList());

        return ((gerichtList.size() > 0)?(Response.ok(gerichtDTOList)):(Response.status(404))).build();
    }

}
