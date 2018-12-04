package it.sevenbits.storages;

import it.sevenbits.Pair;
import it.sevenbits.Planet;
import it.sevenbits.exceptions.FixedStorageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PlanetFixedStorage implements IFixedStorage {
    private Pair[] pairs;
    private int count;
    private final static Logger logger = LoggerFactory.getLogger(PlanetFixedStorage.class);

    public PlanetFixedStorage(int size) {
        pairs = new Pair[size];
        count = 0;
    }
    private boolean containsKey(String key) {
        return findPosition(key) != -1;
    }
    private int findPosition(String key) {
        for (int i = 0; i < count; i++) {
            if(pairs[i].getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }
    private void replace(String key, Planet value) throws FixedStorageException {
        int position = findPosition(key);
        if(position == -1) {
            throw new FixedStorageException("No such key to replace the value");
        }
                pairs[position] = new Pair(key, value);
    }
    @Override
    public void add(String key, Planet value) throws FixedStorageException {
        if(count == pairs.length) {
            logger.error("Cannot add the element", value);
            return;
        }
        if(containsKey(key)) {
            logger.warn("duplicate");
            replace(key, value);
            return;
        }
        pairs[count] = new Pair(key, value);
        count++;
        logger.info("added new element");
    }

    @Override
    public Planet remove(String key) throws FixedStorageException {
        if(count == 0) {
            logger.error("The storage is empty");
            throw new FixedStorageException("The storage is empty");
        }
        if(!containsKey(key)) {
            logger.error("No such element");
            throw new FixedStorageException("No such element");
        }
        int position = findPosition(key);
        Planet removedPlanet = pairs[position].getValue();
        for (int i = position; i < count - 1; i++) {
            pairs[i] = pairs[i+1];
        }
        count--;
        pairs[count] = null;
        logger.info("removed element with key: " + key);
        return removedPlanet;
    }

    @Override
    public boolean contains(Planet value) {
        for (int i = 0; i < count; i++) {
            if(pairs[i].getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }
}
