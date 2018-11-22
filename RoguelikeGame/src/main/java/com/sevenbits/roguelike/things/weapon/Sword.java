package com.sevenbits.roguelike.things.weapon;

import com.sevenbits.roguelike.things.weapon.IWeapon;

public class Sword implements IWeapon {
    private final int id = 8;
    private final int damageLevel = 15;
    private int useAmount;
    private boolean useable;
    @Override
    public int getDamageLevel() {
        if(useable) {
            return damageLevel;
        }
        return 0;
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
        return "Sword{" +
                "id=" + id +
                ", damageLevel=" + damageLevel +
                ", useAmount=" + useAmount +
                ", useable=" + useable +
                '}';
    }
}
