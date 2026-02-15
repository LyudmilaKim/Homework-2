package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractEnemy implements Enemy {
    public String name;
    public int health;
    public int damage;
    public int defense;
    public int speed;
    public String element;
    public List<Ability> abilities = new ArrayList<>();
    public Map<Integer, Integer> phases;
    public LootTable lootTable;
    public String aiBehavior;
    public boolean canFly;
    public boolean hasBreathAttack;
    public int wingspan;

    @Override
    public String getName() { return name; }
    @Override
    public int getHealth() { return health; }
    @Override
    public int getDamage() { return damage; }
    @Override
    public int getDefense() { return defense; }
    @Override
    public int getSpeed() { return speed; }
    @Override
    public List<Ability> getAbilities() { return abilities; }
    @Override
    public LootTable getLootTable() { return lootTable; }

    @Override
    public void multiplyStats(double multiplier) {
        this.health = (int) (this.health * multiplier);
        this.damage = (int) (this.damage * multiplier);
        this.defense = (int) (this.defense * multiplier);
        this.speed = (int) (this.speed * multiplier);
    }

    @Override
    public void setElement(String element) {
        this.element = element;
    }
    @Override
    public abstract Enemy clone();
}