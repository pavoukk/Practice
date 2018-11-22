package com.sevenbits.roguelike.chests;

import com.sevenbits.roguelike.things.IThing;

import java.util.List;

public class WoodChest implements IChest {
    private static int id = 10;
    private List<IThing> content;
    private boolean open;

    public WoodChest(List<IThing> content) {
        this.content = content;
        open = false;
    }

    @Override
    public List<IThing> getContent() {
        return content;
    }

    @Override
    public IThing getThing(int id) {
        return content.get(id);
    }

    @Override
    public boolean open() {
        return open;
    }

    @Override
    public int getId() {
        return id;
    }
}
