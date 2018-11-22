package com.sevenbits.roguelike.chests;

import com.sevenbits.roguelike.IEntity;
import com.sevenbits.roguelike.things.IThing;

import java.util.List;

public interface IChest extends IEntity {
    List<IThing> getContent();
    IThing getThing(int id);
    boolean open();
}
