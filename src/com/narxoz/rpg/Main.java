package com.narxoz.rpg;

import com.narxoz.rpg.builder.BasicEnemyBuilder;
import com.narxoz.rpg.builder.BossEnemyBuilder;
import com.narxoz.rpg.builder.EnemyBuilder;
import com.narxoz.rpg.builder.EnemyDirector;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.FlameBreath;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;
import com.narxoz.rpg.factory.FireComponentFactory;
import com.narxoz.rpg.factory.IceComponentFactory;
import com.narxoz.rpg.factory.ShadowComponentFactory;
import com.narxoz.rpg.prototype.EnemyRegistry;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG Enemy System - Creational Patterns Capstone ===\n");

        System.out.println("============================================");
        System.out.println("PART 1: ABSTRACT FACTORY - Themed Components");
        System.out.println("============================================\n");

        EnemyComponentFactory fireFactory = new FireComponentFactory();
        System.out.println("Fire Theme Components:");
        for (Ability a : fireFactory.createAbilities()) {
            System.out.println("  - " + a.getName() + ": " + a.getDescription());
        }
        System.out.println("  Loot: " + fireFactory.createLootTable().getItems());
        System.out.println("  AI: " + fireFactory.createAIBehavior() + "\n");

        EnemyComponentFactory iceFactory = new IceComponentFactory();
        System.out.println("Ice Theme Components:");
        for (Ability a : iceFactory.createAbilities()) {
            System.out.println("  - " + a.getName() + ": " + a.getDescription());
        }
        System.out.println("  Loot: " + iceFactory.createLootTable().getItems());
        System.out.println("  AI: " + iceFactory.createAIBehavior() + "\n");

        EnemyComponentFactory shadowFactory = new ShadowComponentFactory();
        System.out.println("Shadow Theme Components:");
        for (Ability a : shadowFactory.createAbilities()) {
            System.out.println("  - " + a.getName() + ": " + a.getDescription());
        }
        System.out.println("  Loot: " + shadowFactory.createLootTable().getItems());
        System.out.println("  AI: " + shadowFactory.createAIBehavior() + "\n");

        System.out.println("============================================");
        System.out.println("PART 2: BUILDER + FACTORY METHOD");
        System.out.println("============================================\n");

        EnemyBuilder bossBuilder = new BossEnemyBuilder();
        EnemyDirector director = new EnemyDirector(bossBuilder);
        Enemy fireDragon = director.createDragonBoss(fireFactory);
        System.out.println("Created Fire Dragon Boss (via Builder + Factory Method):");
        fireDragon.displayInfo();
        System.out.println();

        EnemyBuilder basicBuilder = new BasicEnemyBuilder();
        director = new EnemyDirector(basicBuilder);
        Enemy goblin = director.createGoblinMinion(shadowFactory);
        System.out.println("Created Shadow Goblin Minion:");
        goblin.displayInfo();
        System.out.println();

        System.out.println("============================================");
        System.out.println("PART 3: PROTOTYPE - Cloning & Variants");
        System.out.println("============================================\n");

        EnemyRegistry registry = new EnemyRegistry();
        registry.registerTemplate("dragon", fireDragon);
        registry.registerTemplate("goblin", goblin);

        Enemy eliteDragon = registry.getClone("dragon");
        eliteDragon.multiplyStats(2.0);
        System.out.println("Elite Dragon (2x stats):");
        eliteDragon.displayInfo();
        System.out.println();

        Enemy iceGoblin = registry.getClone("goblin");
        iceGoblin.setElement("ICE");
        System.out.println("Ice Variant of Goblin:");
        iceGoblin.displayInfo();
        System.out.println();

        System.out.println("Deep copy demonstration (abilities):");
        Enemy original = registry.getClone("dragon");
        Enemy modifiedClone = registry.getClone("dragon");

        if (!modifiedClone.getAbilities().isEmpty()) {
            modifiedClone.getAbilities().set(0, new FlameBreath() {
                @Override
                public String getName() {
                    return "SUPER FLAME BREATH";
                }

                @Override
                public String getDescription() {
                    return "Modified for deep copy test!";
                }
            });
        }

        System.out.println("Original (should still have regular Flame Breath):");
        original.displayInfo();

        System.out.println("\nModified clone:");
        modifiedClone.displayInfo();

        System.out.println("============================================");
        System.out.println("PART 4: ALL PATTERNS WORKING TOGETHER");
        System.out.println("============================================\n");

        Enemy shadowDemon = new BossEnemyBuilder()
                .setName("Shadow Demon Lord")
                .setHealth(30000)
                .setDamage(300)
                .setDefense(150)
                .setSpeed(45)
                .setAbilities(shadowFactory.createAbilities())
                .setLootTable(shadowFactory.createLootTable())
                .setAI(shadowFactory.createAIBehavior())
                .build();

        registry.registerTemplate("shadow-demon", shadowDemon);

        Enemy greaterDemon = registry.getClone("shadow-demon");
        greaterDemon.multiplyStats(1.5);

        System.out.println("Shadow Demon Lord (base):");
        shadowDemon.displayInfo();
        System.out.println("\nGreater Demon (1.5x variant):");
        greaterDemon.displayInfo();
    }
}