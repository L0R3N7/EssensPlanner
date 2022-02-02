package me.workloads.person.logic;

import me.models.TagesplanDTO;
import me.workloads.person.Tagesplan;

import java.time.LocalDate;
import java.util.List;

public interface TagesPlanService {
    void deleteWeek(LocalDate localDate, Long personId);

    void addWeek(List<TagesplanDTO> wochenPlan, Long personId);

    List<Tagesplan> getWeek(LocalDate localDate, Long personId);
}
