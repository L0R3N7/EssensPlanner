package me.workloads.person.logic;

import me.workloads.person.Tagesplan;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class TagesPlanRepoImpl implements TagesPlanRepo{
    @Inject
    EntityManager entityManager;

    @Override
    public List<Tagesplan> getWeek(LocalDate localDate, Long personId) {

        LocalDate endOfWeek = localDate.plusWeeks(1);

        TypedQuery<Tagesplan> typedQuery = this.entityManager
                .createQuery("select t from Tagesplan t where t.id.personId = :personId and t.id.localDate between :startOfWeek and :endOfWeek order by t.id.localDate", Tagesplan.class)
                .setParameter("personId", personId)
                .setParameter("startOfWeek", localDate)
                .setParameter("endOfWeek", endOfWeek);

        return typedQuery.getResultStream().collect(Collectors.toList());
    }

    @Override
    public void deleteDay(LocalDate days, Long person) {
        Query query = this.entityManager
                .createQuery("delete from Tagesplan t where t.id.localDate = :day and t.id.personId = :person")
                .setParameter("person", person)
                .setParameter("day", days);
        query.executeUpdate();
    }

    @Override
    public void deleteWeek(LocalDate monday, Long person){
        var sunday = monday.plusWeeks(1);

        var query = this.entityManager
                .createQuery("delete from Tagesplan t where t.id.localDate between :mondey and :sunday and t.id.personId = :person")
                .setParameter("person", person)
                .setParameter("sunday", sunday)
                .setParameter("mondey", monday);

        query.executeUpdate();
    }

    @Override
    public List<Tagesplan> getTagesPläne(LocalDate localDate) {
        List<Tagesplan> tagesplans = new ArrayList<>();

        for (int i = 0 ; i < 7; i++){
            TypedQuery<Tagesplan> typedQuery = this.entityManager
                    .createQuery("select t from Tagesplan t where t.id.localDate = :localdate", Tagesplan.class)
                    .setParameter("localdate", localDate.plusDays(i));
            tagesplans.add(typedQuery.getResultStream().findFirst().orElse(null));
        }

        return tagesplans;
    }

    @Override
    public void delete(List<Tagesplan> tagesPlans) {
        for (Tagesplan tagesplan : tagesPlans){
            if (tagesplan == null){continue;}
            this.entityManager.remove(tagesplan);
        }

        /*Query query =  this.entityManager.createQuery("delete from Tagesplan t where t in :tagesplans")
                .setParameter("tagesplans", tagesPlans);
        query.executeUpdate();*/
    }



    @Override
    public void add(Tagesplan tagesplan) {
        this.entityManager.persist(tagesplan);
    }
}
