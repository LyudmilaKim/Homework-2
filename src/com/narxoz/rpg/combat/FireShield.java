package com.narxoz.rpg.combat;

public class FireShield implements Ability {
    @Override
    public String getName() {
        return "Fire Shield";
    }

    @Override
    public int getDamage() {
        return 50;
    }

    @Override
    public String getDescription() {
        return "Creates a shield of fire that buffs defense and damages attackers.";
    }

    @Override
    public Ability clone() {
        return new FireShield();
    }
}