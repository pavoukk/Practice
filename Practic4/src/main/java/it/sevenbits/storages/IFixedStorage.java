package it.sevenbits.storages;

import it.sevenbits.Planet;
import it.sevenbits.exceptions.FixedStorageException;

public interface IFixedStorage {
    void add(String key, Planet value) throws FixedStorageException;
    Planet remove(String key) throws FixedStorageException;
    boolean contains(Planet value);
}
