package com.sevenbits.roguelike.creatures.players;

import com.sevenbits.roguelike.SomethingGoneWrongException;
import com.sevenbits.roguelike.creatures.ICreature;
import com.sevenbits.roguelike.things.IThing;
import com.sevenbits.roguelike.inventory.IInventory;
import com.sevenbits.roguelike.inventory.Inventory;

public class DefaultPlayer implements IPlayer, ICreature {
    private final int id = 1;
    private int health;
    private int hunger;
    private int sleepNeed;
    private IInventory inventory;
    private boolean leftHandState;
    private boolean rightHandState;
    private boolean alive;
    private static DefaultPlayer player = null;

    public DefaultPlayer(int health, int hunger, int sleepNeed, IInventory inventory, boolean leftHandState, boolean rightHandState, boolean alive) {
        this.health = health;
        this.hunger = hunger;
        this.sleepNeed = sleepNeed;
        this.inventory = inventory;
        this.leftHandState = leftHandState;
        this.rightHandState = rightHandState;
        this.alive = alive;
    }

    private void setHealth(int health) throws SomethingGoneWrongException {
        if (health > 100 || health < 0) {
            throw new SomethingGoneWrongException("incorrent health state: " + health);
        }
        this.health = health;
    }

    private void setHunger(int hunger) throws SomethingGoneWrongException {
        if (hunger > 100 || hunger < 0) {
            throw new SomethingGoneWrongException("incorrect hunger state: " + hunger);
        }
        this.hunger = hunger;
    }

    private void setSleepNeed(int sleepNeed) throws SomethingGoneWrongException {
        if (sleepNeed > 100 || sleepNeed < 0) {
            throw new SomethingGoneWrongException("incorrect sleepNeed state: " + sleepNeed);
        }
        this.sleepNeed = sleepNeed;
    }

    private void setInventory(IInventory inventory) {
        this.inventory = inventory;
    }

    private void setLeftHandState(boolean leftHandState) {
        this.leftHandState = leftHandState;
    }

    private void setRightHandState(boolean rightHandState) {
        this.rightHandState = rightHandState;
    }

    public static IPlayer getPlayer() throws SomethingGoneWrongException {
        if (player == null) {
            player = new DefaultPlayer(100, 100, 100, new Inventory(), false, false, true);
        }
        return player;
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
        health -= damage;
        if (health <= 0) {
            alive = false;
        }
    }

    @Override
    public int getHungerState() {
        return hunger;
    }

    @Override
    public int getSleepNeed() {
        return sleepNeed;
    }

    public IInventory getInventory() {
        return inventory;
    }

    public boolean isLeftHandState() {
        return leftHandState;
    }

    public boolean isRightHandState() {
        return rightHandState;
    }

    public IThing getThing(int id) throws SomethingGoneWrongException {
        return inventory.getThing(id);
    }

}
