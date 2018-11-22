package com.sevenbits.roguelike.inventory;

import com.sevenbits.roguelike.IEntity;
import com.sevenbits.roguelike.SomethingGoneWrongException;
import com.sevenbits.roguelike.things.IThing;

public interface IInventory extends IEntity {
    IThing getThing(int id) throws SomethingGoneWrongException;
    void addToInventory(IThing IThing) throws SomethingGoneWrongException;
}
