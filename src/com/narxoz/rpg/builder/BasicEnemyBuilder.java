package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;

public class BasicEnemyBuilder implements EnemyBuilder {
    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private String element;
    private List<Ability> abilities = new ArrayList<>();
    private LootTable lootTable;
    private String aiBehavior;

    @Override
    public EnemyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public EnemyBuilder setHealth(int health) {
        this.health = health;
        return this;
    }

    @Override
    public EnemyBuilder setDamage(int damage) {
        this.damage = damage;
        return this;
    }

    @Override
    public EnemyBuilder setDefense(int defense) {
        this.defense = defense;
        return this;
    }

    @Override
    public EnemyBuilder setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    @Override
    public EnemyBuilder setElement(String element) {
        this.element = element;
        return this;
    }

    @Override
    public EnemyBuilder setAbilities(List<Ability> abilities) {
        this.abilities = abilities != null ? abilities : new ArrayList<>();
        return this;
    }

    @Override
    public EnemyBuilder setLootTable(LootTable lootTable) {
        this.lootTable = lootTable;
        return this;
    }

    @Override
    public EnemyBuilder setAI(String aiBehavior) {
        this.aiBehavior = aiBehavior;
        return this;
    }

    @Override
    public EnemyBuilder addPhase(int phase, int threshold) {
        return this;
    }

    @Override
    public EnemyBuilder setCanFly(boolean canFly) {
        return this;
    }

    @Override
    public EnemyBuilder setHasBreathAttack(boolean hasBreathAttack) {
        return this;
    }

    @Override
    public EnemyBuilder setWingspan(int wingspan) {
        return this;
    }

    @Override
    public Enemy build() {
        if (name == null || health <= 0) {
            throw new IllegalStateException("Name and health are required!");
        }

        Goblin goblin = new Goblin(name);
        goblin.health = health;
        goblin.damage = damage;
        goblin.defense = defense;
        goblin.speed = speed;
        goblin.element = element;
        goblin.abilities = abilities;
        goblin.lootTable = lootTable;
        goblin.aiBehavior = aiBehavior;

        return goblin;
    }
}