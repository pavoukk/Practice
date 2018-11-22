package com.sevenbits.roguelike.creatures.players;

import com.sevenbits.roguelike.IEntity;
import com.sevenbits.roguelike.SomethingGoneWrongException;
import com.sevenbits.roguelike.things.IThing;
import com.sevenbits.roguelike.inventory.IInventory;

public interface IPlayer extends IEntity {
    //    static IPlayer getPlayer() throws SomethingGoneWrongException{
//        return null;
//    }
    int getHungerState();

    int getSleepNeed();

    IInventory getInventory();

    IThing getThing(int id) throws SomethingGoneWrongException;
}
