package com.sevenbits.roguelike.things.protection;

import com.sevenbits.roguelike.things.weapon.IWeapon;
import com.sevenbits.roguelike.things.IThing;

import java.util.List;

public interface IProtection extends IThing {
    List<IWeapon> getProtectedFromList();
}
