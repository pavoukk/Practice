package it.sevenbits;

import it.sevenbits.Planet;

public class Pair {
    private String key;
    private Planet value;

    public Pair(String key, Planet value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Planet getValue() {
        return value;
    }
}
