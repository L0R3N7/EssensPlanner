package me.workloads.gerichte.logic;

import me.api.GerichtResource;
import me.workloads.gerichte.Gericht;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class GerichtServiceImpl implements GerichtService{

    @Inject
    private GerichtRepo gerichtRepo;

    @Override
    public List<Gericht> search(String searchString) {
        return this.gerichtRepo.search(searchString);
    }
}
