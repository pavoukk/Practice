package com.sevenbits.roguelike.creatures.monsters;

public class Zombie implements IMonster {
    private final int id = 3;
    private final int damageLevel = 30;
    private boolean alive;
    private int health = 10;

    public Zombie(){
        alive = true;
    }
    @Override
    public int attack() {
        if(alive) {
            return damageLevel;
        }
        return 0;
    }

    @Override
    public int getId() {
        return id;
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
    public void suffer(int damage) {
        health-=damage;
        if(health <= 0){
            alive = false;
        }
    }
}
