package it.sevenbits;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;

public class Planet {
    private String name;
    private String id;

    public Planet(final String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return Objects.equals(name, planet.name) &&
                Objects.equals(id, planet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}