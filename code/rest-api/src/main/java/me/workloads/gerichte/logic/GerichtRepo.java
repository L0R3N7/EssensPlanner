package me.workloads.gerichte.logic;

import me.workloads.gerichte.Gericht;

import java.util.List;

public interface GerichtRepo {

    List<Gericht> search(String searchString);
}
