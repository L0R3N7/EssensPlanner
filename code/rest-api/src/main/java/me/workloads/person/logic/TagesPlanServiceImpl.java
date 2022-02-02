package me.workloads.person.logic;

import me.models.TagesplanDTO;
import me.models.mapper.Mappings;
import me.workloads.gerichte.logic.GerichtRepo;
import me.workloads.person.Tagesplan;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;


@ApplicationScoped
public class TagesPlanServiceImpl implements TagesPlanService{
    @Inject
    TagesPlanRepo tagesPlanRepo;
    @Inject
    GerichtRepo gerichtRepo;
    @Inject
    PersonRepo personRepo;

    @Override
    public List<Tagesplan> getWeek(LocalDate localDate, Long personId) {
        return this.tagesPlanRepo.getWeek(localDate, personId);
    }

    @Override
    public void deleteWeek(LocalDate localDate, Long personId) {
        for (int i = 0; i < 7; i++){
            this.tagesPlanRepo.deleteDay(localDate.plusDays(i), personId);
        }
    }

    @Override
    public void addWeek(List<TagesplanDTO> wochenPlan, Long personId) {
        for (int i = 0; i < wochenPlan.size(); i++){
            System.out.println(wochenPlan.get(i).getIdPersonEmail() + " "+(wochenPlan.get(i).getIdLocalDate()));
            Tagesplan tagesplan = Tagesplan.create(personId, Mappings.StringToLocalDate(wochenPlan.get(i).getIdLocalDate()));

            for (Long j : wochenPlan.get(i).getGerichtListIds()){
                tagesplan.addGerichteListe(j);
                System.out.println("Gericht: "+ j);
            }

            System.out.println();
            this.tagesPlanRepo.add(tagesplan);
        }
    }

    /*@Override
    public void updatePlannedWeek(LocalDate localDate, Person person, List<TagesplanDTO> tagesplanDTOs) {
        // Delete existing
        List<Tagesplan> wochenPlan = tagesPlanRepo.getTagesPlänne(localDate);
        this.tagesPlanRepo.delete(wochenPlan);

        // Create and add new Tagesplan
        for (int i = 0; i < wochenPlan.size(); i++){
            LocalDate wochenTag = localDate.plusDays(i);

            Tagesplan wochenTag =  Tagesplan.create(person.getId(), wochenTag);

            for (int j = 0; j < tagesplanDTOs.get(i).getGerichtListIds().size(); i++){
                Gericht gerichtTemp = this.gerichtRepo.getGerichtById(tagesplanDTOs.get(i).getGerichtListIds().get(j));

                // Creates TagesplanGericht and adds to parameters this and the other way around



                GerichteListe gerichteListe = GerichteListe.create(wochenTag, gerichtTemp, j);
                //tagesplanTemp.addTagesplanGerichtes(tagesplanGerichte);
                //gerichtTemp.addTagesplanGerichtes(tagesplanGerichte);
                this.tagesPlanRepo.add(gerichteListe);
            }
            this.tagesPlanRepo.add(wochenTag);
        }
    }*/
}
