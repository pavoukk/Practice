package com.sevenbits.roguelike;

import com.sevenbits.roguelike.things.protection.Armor;
import com.sevenbits.roguelike.things.IThing;
import com.sevenbits.roguelike.things.weapon.Sword;
import com.sevenbits.roguelike.chests.IChest;
import com.sevenbits.roguelike.chests.WoodChest;
import com.sevenbits.roguelike.coins.GoldCoin;
import com.sevenbits.roguelike.coins.SilverCoin;
import com.sevenbits.roguelike.creatures.ICreature;
import com.sevenbits.roguelike.creatures.monsters.IMonster;
import com.sevenbits.roguelike.creatures.monsters.Witch;
import com.sevenbits.roguelike.creatures.monsters.Zombie;
import com.sevenbits.roguelike.creatures.players.DefaultPlayer;
import com.sevenbits.roguelike.creatures.players.IPlayer;
import com.sevenbits.roguelike.systems.DeathSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            List<IThing> list = new ArrayList<>();
            list.add(new Sword());
            list.add(new Armor(new ArrayList<>()));
            list.add(new GoldCoin());
            list.add(new SilverCoin());
            IPlayer player = DefaultPlayer.getPlayer();
            IMonster witch = new Witch();
            IMonster zombie = new Zombie();
            IChest chest = new WoodChest(list);
            for (IThing IThing : chest.getContent()) {
                player.getInventory().addToInventory(IThing);
            }
            System.out.println(player.getThing(9)); // expected Armor
            System.out.println(player.getThing(8)); // sword
            System.out.println(player.getThing(6)); // gold coin??
            System.out.println(player.getThing(10));
            DeathSystem.makeSuffer(witch.attack(), (ICreature) player);
            DeathSystem.makeSuffer(zombie.attack(), (ICreature) player);
            //isProtected = true if protection is on
            System.out.println(((ICreature) player).isAlive());
        } catch (SomethingGoneWrongException e) {
            System.out.println(e.getInformation());
            e.printStackTrace();
        }
    }
}
