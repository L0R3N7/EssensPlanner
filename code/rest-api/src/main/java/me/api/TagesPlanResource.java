package me.api;

import me.models.GerichtDTO;
import me.models.PersonDTO;
import me.models.TagesplanDTO;
import me.models.TagesplanDTOo;
import me.models.mapper.Mappings;
import me.workloads.person.Person;
import me.workloads.person.Tagesplan;
import me.workloads.person.logic.PersonService;
import me.workloads.person.logic.TagesPlanService;
import org.mapstruct.Mapping;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Path("tagesplan")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TagesPlanResource {
    @Inject
    PersonService personService;
    @Inject
    TagesPlanService tagesPlanService;

    @POST
    @Path("week/{date}")
    public Response getWeek(
            @PathParam("date") String date, PersonDTO personDTO
    ){
        System.out.println("week get");
        Person person = this.personService.getUser(personDTO.getEmail(), Mappings.StringToHash(personDTO.getUniqueSessionCode()));
        if (person == null){
            return Response.status(404).build();
        }
        LocalDate localDate = Mappings.StringToLocalDate(date).with(DayOfWeek.MONDAY);

        List<Tagesplan> weekPlan = this.tagesPlanService.getWeek(localDate, person.getId());
        List<TagesplanDTOo> weekPlanDto = Mappings.INSTANCE.tagesplanToTageslplanDtoo(weekPlan);

        return Response.ok(weekPlanDto).build();
    }

    @Transactional
    @DELETE
    @Path("week/{date}")
    public Response deleteWeek(
            @PathParam("date") String date, PersonDTO personDTO
    ){
        System.out.println("week löscht");
        Person person = this.personService.getUser(personDTO.getEmail(), Mappings.StringToHash(personDTO.getUniqueSessionCode()));
        if (person == null){
            return Response.status(404).build();
        }
        LocalDate localDate = Mappings.StringToLocalDate(date).with(DayOfWeek.MONDAY);
        tagesPlanService.deleteWeek(localDate, person.getId());
        return Response.ok().build();
    }

    @Transactional
    @POST
    @Path("week")
    public Response addWeek(
            List<TagesplanDTO> wochenPlan
    ){
        Person person = this.personService.getUser(wochenPlan.get(0).getIdPersonEmail(), Mappings.StringToHash(wochenPlan.get(0).getIdPersonUniqueSessionCode()));
        if (person == null){
            return Response.status(404).build();
        }

        if (wochenPlan.size() != 7){
            return Response.status(400).build();
        }

        this.tagesPlanService.addWeek(wochenPlan, person.getId());
        return Response.ok().build();
    }

    /*@Transactional
    @PUT
    @Path("week")
    public Response updatePlannedWeek(
            List<TagesplanDTO> tagesplanDTO
    ){
        //LocalDate localDate = Mappings.StringToLocalDate(localDateString);
        LocalDate localDate = Mappings.StringToLocalDate(tagesplanDTO.get(0).getIdLocalDate()).with(DayOfWeek.MONDAY);

        Person person = this.personService.getUser(tagesplanDTO.get(0).getIdPersonEmail(), Mappings.StringToHash(tagesplanDTO.get(0).getIdPersonUniqueSessionCode()));
        if (person == null){
            return Response.status(404).build();
        }

        if (tagesplanDTO.size() != 7){
            return Response.status(400).build();
        }

        tagesPlanService.updatePlannedWeek(localDate, person, tagesplanDTO);
        return Response.ok().build();
    }*/

}
