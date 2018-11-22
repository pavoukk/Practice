package com.sevenbits.roguelike.creatures.monsters;

public class Witch implements  IMonster {
    private final int id = 4;
    private int health = 100;
    private final int damageLevel = 15;
    private boolean alive;

    public Witch(){
        alive = true;
    }
    @Override
    public int getHealthState() {
        return health;
    }

    @Override
    public boolean isAlive() {
        return alive;
    }

    @Override
    public int attack() {
        if (alive) {
            return damageLevel;
        }
        return 0;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void suffer(int damage) {
        health -= damage;
        if (health <= 0) {
            alive = false;
        }
    }
}
