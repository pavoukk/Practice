package com.sevenbits.roguelike.things;

import com.sevenbits.roguelike.IEntity;

public interface IThing extends IEntity {
    int getUseAmount();
    boolean use();
    boolean isUseable();
}
