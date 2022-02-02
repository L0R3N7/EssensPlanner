package me.workloads.person.logic;

import me.models.TagesplanDTO;
import me.workloads.person.Tagesplan;

import java.time.LocalDate;
import java.util.List;

public interface TagesPlanRepo {
    List<Tagesplan> getTagesPläne(LocalDate localDate);

    void delete(List<Tagesplan> tagesPlans);

    void add(Tagesplan tagesplan);

    /*void add(GerichteListe gerichteListe);

    List<GerichteListe> getTagesPlänneGerichte(LocalDate localDate);

    void deleteTagesPlanGerichtes(List<GerichteListe> gerichteListes);*/

    void deleteDay(LocalDate days, Long person);

    List<Tagesplan> getWeek(LocalDate localDate, Long personId);
}
