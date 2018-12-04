package it.sevenbits.storages;

import it.sevenbits.Planet;
import it.sevenbits.exceptions.UniqueStorageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlanetUniqueStorage implements IUniqueStorage {
    private final static Logger logger = LoggerFactory.getLogger(PlanetUniqueStorage.class);
    private Planet[] planets;
    private int count;
    private final int APPEND = 10;

    public PlanetUniqueStorage() {
        planets = new Planet[10];
        count = 0;
    }
    public PlanetUniqueStorage(int size) throws UniqueStorageException {
        if(size <= 0) {
            logger.error("Incorrect size value");
            throw new UniqueStorageException("Incorrect size value");
        }
        planets = new Planet[size];
        count = 0;
    }
    private void resize() {
        Planet[] resizedArr = new Planet[planets.length + APPEND];
        for (int i = 0; i < planets.length; i++) {
            resizedArr[i] = planets[i];
        }
        planets = resizedArr;
    }
    @Override
    public void add(Planet planet) {
        if(count == planets.length) {
            resize();
        }
        if(contains(planet)) {
            logger.warn("duplicate");
        }
        planets[count] = planet;
        count++;
        logger.info("added new element");
    }

    @Override
    public Planet remove() throws UniqueStorageException {
        if(count == 0) {
            logger.error("The storage is empty");
            throw new UniqueStorageException("The storage is empty");
        }
        count--;
        Planet removed = planets[count];
        planets[count] = null;
        logger.info("removed element");
        return removed;
    }

    @Override
    public boolean contains(Planet planet) {
        for (int i = 0; i < count; i++) {
            if(planets[i].equals(planet)) {
                return true;
            }
        }
        return false;
    }
}
