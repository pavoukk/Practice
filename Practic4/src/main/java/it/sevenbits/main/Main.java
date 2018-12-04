package it.sevenbits.main;

import it.sevenbits.Planet;
import it.sevenbits.exceptions.FixedStorageException;
import it.sevenbits.exceptions.UniqueStorageException;
import it.sevenbits.storages.PlanetFixedStorage;
import it.sevenbits.storages.PlanetUniqueStorage;

public class Main {
    public static void main(String[] args) throws FixedStorageException, UniqueStorageException {
        PlanetUniqueStorage storage = new PlanetUniqueStorage();
        Planet pluto = new Planet("Pluto");
        Planet earth = new Planet("Earth");
        Planet mars = new Planet("Mars");
        Planet mercury = new Planet("Mercury");
        Planet jupiter = new Planet("Jupiter");
        Planet venera = new Planet("Venera");
        Planet saturn = new Planet("Saturn");
        Planet secondEarth = new Planet("kepler 452b");
        storage.add(pluto);
        storage.add(earth);
        storage.add(mars);
        storage.add(mars);
        storage.add(mercury);
        storage.add(jupiter);
        storage.add(venera);
        System.out.println(storage.contains(venera)); //true

        PlanetFixedStorage fixedStorage = new PlanetFixedStorage(7);
        fixedStorage.add(pluto.getId(), pluto);
        fixedStorage.add(earth.getId(), earth);
        fixedStorage.add(mars.getId(), mars);
        fixedStorage.add(mercury.getId(), mercury);
        fixedStorage.add(venera.getId(), venera);
        fixedStorage.add(saturn.getId(), saturn);
        fixedStorage.add(secondEarth.getId(), secondEarth);
        System.out.println(fixedStorage.contains(pluto));
        System.out.println(fixedStorage.contains(earth));
        System.out.println(fixedStorage.contains(jupiter));
        fixedStorage.add(jupiter.getId(), jupiter);

        System.out.println(storage.contains(fixedStorage.remove(pluto.getId())));
        System.out.println(storage.contains(fixedStorage.remove(earth.getId())));
        System.out.println(storage.contains(fixedStorage.remove(mars.getId())));
        System.out.println(storage.contains(fixedStorage.remove(mercury.getId())));
        System.out.println(storage.contains(fixedStorage.remove(venera.getId())));
        System.out.println(storage.contains(fixedStorage.remove(saturn.getId())));
        System.out.println(storage.contains(fixedStorage.remove(secondEarth.getId())));
    }
}
