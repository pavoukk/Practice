package com.sevenbits.roguelike.systems;

import com.sevenbits.roguelike.creatures.ICreature;

public class DeathSystem implements ISystem {

    public static void makeSuffer(int damage, ICreature creature) {
        creature.suffer(damage);
    }
}
