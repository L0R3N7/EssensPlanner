package me.api;

import me.models.GerichtDTO;
import me.models.PersonDTO;
import me.models.mapper.Mappings;
import me.workloads.gerichte.Gericht;
import me.workloads.gerichte.logic.GerichtService;
import me.workloads.person.FavouriteGerichte;
import me.workloads.person.Person;
import me.workloads.person.logic.favourite.FavouriteGerichteService;
import me.workloads.person.logic.PersonService;

import javax.inject.Inject;
import javax.transaction.Transactional;
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
    @Inject
    FavouriteGerichteService favouriteGerichteService;

    @POST
    @Path("ids")
    public Response searchByIds(
            List<Long> ids
    ){
        List<Gericht> gerichtList = ids.stream().map(aLong -> {return this.gerichtService.getGerichtById(aLong);}).collect(Collectors.toList());
        return Response.ok(Mappings.INSTANCE.gerichtListeToGerichtDTOListe(gerichtList)).build();
    }

    @GET
    @Path("search/{searchString}")
    public Response search(
            @PathParam("searchString") String searchString
    ){
        List<Gericht> gerichtList = this.gerichtService.search(searchString);
        List<GerichtDTO> gerichtDTOList = gerichtList.stream().map(Mappings.INSTANCE::gerichtToGerichtDTO).collect(Collectors.toList());

        return ((gerichtList.size() > 0)?(Response.ok(gerichtDTOList)):(Response.status(404))).build();
    }

    @POST
    @Path("isFavorite/{id}")
    public Response isFavorite(
            PersonDTO personDTO,
            @PathParam("id") long gerichtId
    ){
        System.out.println("User asks what his favorite Meal is");
        Person person = personService.getUser(personDTO.getEmail(), Mappings.StringToHash(personDTO.getUniqueSessionCode()));

        if (person == null){
            return Response.status(404).build();
        }

        return Response.ok(this.gerichtService.isFavorite(person, gerichtId)).build();
    }

    @PUT
    @Path("setFavorite/{id}/{bool}")
    @Transactional
    public Response setFavorite(
            PersonDTO personDTO,
            @PathParam("id") long gerichtId,
            @PathParam("bool") boolean fav
    ){
        System.out.println("User wanna change his favorite meal");
        Person person = this.personService.getUser(personDTO.getEmail(), Mappings.StringToHash(personDTO.getUniqueSessionCode()));

        if (person == null){
            return Response.status(404).build();
        }

        Gericht gericht = this.gerichtService.getGerichtById(gerichtId);

        FavouriteGerichte favouriteGerichte;

        if (fav){
            favouriteGerichte = FavouriteGerichte.create(person, gericht);
            this.favouriteGerichteService.add(favouriteGerichte);
            this.personService.update(person);
            this.gerichtService.update(gericht);
        }else {
            this.favouriteGerichteService.delete(person, gericht);
        }

        return Response.ok().build();
    }
}
