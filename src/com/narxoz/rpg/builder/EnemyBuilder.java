package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;
import java.util.Map;

public interface EnemyBuilder {
    EnemyBuilder setName(String name);
    EnemyBuilder setHealth(int health);
    EnemyBuilder setDamage(int damage);
    EnemyBuilder setDefense(int defense);
    EnemyBuilder setSpeed(int speed);
    EnemyBuilder setElement(String element);
    EnemyBuilder setAbilities(List<Ability> abilities);
    EnemyBuilder setLootTable(LootTable lootTable);
    EnemyBuilder setAI(String aiBehavior);
    EnemyBuilder addPhase(int phase, int threshold);
    EnemyBuilder setCanFly(boolean canFly);
    EnemyBuilder setHasBreathAttack(boolean hasBreathAttack);
    EnemyBuilder setWingspan(int wingspan);
    Enemy build();
}