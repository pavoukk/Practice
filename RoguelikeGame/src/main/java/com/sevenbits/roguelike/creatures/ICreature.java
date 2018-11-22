package com.sevenbits.roguelike.creatures;

import com.sevenbits.roguelike.IEntity;

public interface ICreature extends IEntity {
    int getHealthState();
    boolean isAlive();
    void suffer(int damage);
}
