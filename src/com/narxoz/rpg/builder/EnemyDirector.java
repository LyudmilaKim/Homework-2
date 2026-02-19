package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;

public class EnemyDirector {
    private EnemyBuilder builder;

    public EnemyDirector(EnemyBuilder builder) {
        this.builder = builder;
    }

    public Enemy createGoblinMinion(EnemyComponentFactory factory) {
        return builder.setName("Goblin Minion")
                .setHealth(100)
                .setDamage(15)
                .setDefense(5)
                .setSpeed(35)
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAIBehavior())
                .build();
    }

    public Enemy createDragonBoss(EnemyComponentFactory factory) {
        return builder.setName("Ancient Dragon")
                .setHealth(50000)
                .setDamage(500)
                .setDefense(200)
                .setSpeed(50)
                .setElement("FIRE")
                .setAbilities(factory.createAbilities())
                .addPhase(1, 50000)
                .addPhase(2, 30000)
                .addPhase(3, 15000)
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAIBehavior())
                .setCanFly(true)
                .setHasBreathAttack(true)
                .setWingspan(20)
                .build();
    }
}