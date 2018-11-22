package com.sevenbits.roguelike.inventory;

import com.sevenbits.roguelike.SomethingGoneWrongException;
import com.sevenbits.roguelike.things.IThing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory implements IInventory {
    private final int id = 2;
    private List<IThing> things;

    public Inventory() {
        things = new ArrayList<>();
    }

    public void addToInventory(IThing thing) throws SomethingGoneWrongException {
        things.add(thing);
    }

    private void autoClean(){
        for (IThing thing : things) {
            if(!thing.isUseable()){
                things.remove(thing);
            }
        }
    }

    public boolean hasThing(int id) throws SomethingGoneWrongException {
        return things.stream().anyMatch(a -> a.getId() == id);
//        for (IThing thing: things) {
//            if(thing.getId() == id){
//                return true;
//            }
//        }
//        return false;
    }
    @Override
    public IThing getThing(int id) throws SomethingGoneWrongException {
        if(hasThing(id)) {
            return things.stream().filter(a -> a.getId() == id).findFirst().get();
        }
//        if(hasThing(id)){
//            for (IThing thing: things) {
//                if(thing.getId() == id){
//                    return thing;
//                }
//            }
//        }
        throw new SomethingGoneWrongException("The inventory doesn't contain: " + id);
    }

    @Override
    public int getId() {
        return id;
    }
}
