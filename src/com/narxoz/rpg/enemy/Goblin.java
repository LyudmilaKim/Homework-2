package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;

public class Goblin extends AbstractEnemy {

    public Goblin(String name) {
        this.name = name;
        this.health = 100;
        this.damage = 15;
        this.defense = 5;
        this.speed = 35;
        this.abilities = new ArrayList<>();
    }

    Goblin() {
    }

    @Override
    public void displayInfo() {
        System.out.println("=== " + (name != null ? name : "Unnamed") + " (Goblin) ===");

        System.out.printf("Health: %d | Damage: %d | Defense: %d | Speed: %d%n",
                health, damage, defense, speed);

        if (element != null) {
            System.out.println("Element: " + element);
        }

        System.out.println("Abilities (" + (abilities != null ? abilities.size() : 0) + "):");
        if (abilities != null && !abilities.isEmpty()) {
            for (Ability a : abilities) {
                System.out.printf("  - %s (damage %d): %s%n",
                        a.getName(), a.getDamage(), a.getDescription());
            }
        }

        if (lootTable != null) {
            System.out.println("Loot Table:");
            System.out.println("  Items: " + lootTable.getItems());
            System.out.println("  Gold: " + lootTable.getGoldDrop());
            System.out.println("  Experience: " + lootTable.getExperienceDrop());
        }

        System.out.println("AI Behavior: " + (aiBehavior != null ? aiBehavior : "None"));

        System.out.println("=".repeat(40));
    }

    @Override
    public Enemy clone() {
        Goblin copy = new Goblin();
        copy.name = this.name;
        copy.health = this.health;
        copy.damage = this.damage;
        copy.defense = this.defense;
        copy.speed = this.speed;
        copy.element = this.element;
        copy.abilities = new ArrayList<>();
        for (Ability a : this.abilities) {
            copy.abilities.add(a.clone());
        }
        if (this.lootTable != null) {
            copy.lootTable = this.lootTable.clone();
        }
        copy.aiBehavior = this.aiBehavior;
        return copy;
    }
}