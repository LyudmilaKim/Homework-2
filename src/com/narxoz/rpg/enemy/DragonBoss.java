package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DragonBoss extends AbstractEnemy {

    public DragonBoss() {
    }

    @Override
    public void displayInfo() {
        System.out.println("=== " + (name != null ? name : "Unnamed") + " (Dragon Boss) ===");

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
        } else {
            System.out.println("  (no abilities)");
        }

        if (phases != null && !phases.isEmpty()) {
            System.out.println("Boss Phases:");
            for (Map.Entry<Integer, Integer> entry : phases.entrySet()) {
                System.out.printf("  Phase %d: triggers at %d HP%n",
                        entry.getKey(), entry.getValue());
            }
        } else {
            System.out.println("No phases defined");
        }

        if (lootTable != null) {
            System.out.println("Loot Table:");
            System.out.println("  Items: " + lootTable.getItems());
            System.out.println("  Gold: " + lootTable.getGoldDrop());
            System.out.println("  Experience: " + lootTable.getExperienceDrop());
        } else {
            System.out.println("No loot table");
        }

        System.out.println("AI Behavior: " + (aiBehavior != null ? aiBehavior : "None"));

        System.out.println("Can Fly: " + canFly +
                " | Has Breath Attack: " + hasBreathAttack +
                " | Wingspan: " + wingspan);

        System.out.println("=".repeat(40));
    }

    @Override
    public Enemy clone() {
        DragonBoss copy = new DragonBoss();
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
        if (this.phases != null) {
            copy.phases = new HashMap<>(this.phases);
        }
        if (this.lootTable != null) {
            copy.lootTable = this.lootTable.clone();
        }
        copy.aiBehavior = this.aiBehavior;
        copy.canFly = this.canFly;
        copy.hasBreathAttack = this.hasBreathAttack;
        copy.wingspan = this.wingspan;
        return copy;
    }
}