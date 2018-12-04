package it.sevenbits.storages;

import it.sevenbits.Planet;
import it.sevenbits.exceptions.UniqueStorageException;

public interface IUniqueStorage {
    void add(Planet planet);
    Planet remove() throws UniqueStorageException;
    boolean contains(Planet planet);
}
