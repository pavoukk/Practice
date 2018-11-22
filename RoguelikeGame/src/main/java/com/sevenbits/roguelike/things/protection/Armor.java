package com.sevenbits.roguelike.things.protection;

import com.sevenbits.roguelike.things.weapon.IWeapon;

import java.util.List;

public class Armor implements IProtection {
    private final int id = 9;
    private int useAmount = 5;
    private boolean useable = true;
    private final List<IWeapon> protectedFrom;
    public Armor(List<IWeapon> protectedFrom){
        this.protectedFrom = protectedFrom;
    }
    @Override
    public List<IWeapon> getProtectedFromList() {
        return protectedFrom;
    }

    @Override
    public int getUseAmount() {
        return useAmount;
    }

    @Override
    public boolean use() {
        if(useAmount > 0){
            useAmount-=1;
            return true;
        }
        return false;
    }

    @Override
    public boolean isUseable() {
        return useable;
    }


    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Armor{" +
                "id=" + id +
                ", useAmount=" + useAmount +
                ", useable=" + useable +
                ", protectedFrom=" + protectedFrom +
                '}';
    }
}

