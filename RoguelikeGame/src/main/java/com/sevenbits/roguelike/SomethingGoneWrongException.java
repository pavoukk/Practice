package com.sevenbits.roguelike;

public class SomethingGoneWrongException extends Exception {
    private String string;
    public SomethingGoneWrongException(String string){
        this.string = string;
    }

    public String getInformation() {
        return string;
    }
}
