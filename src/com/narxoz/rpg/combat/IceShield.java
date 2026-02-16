package com.narxoz.rpg.combat;

public class IceShield implements Ability {
    @Override
    public String getName() {
        return "Ice Shield";
    }

    @Override
    public int getDamage() {
        return 40;
    }

    @Override
    public String getDescription() {
        return "Creates an ice shield for defensive buff.";
    }

    @Override
    public Ability clone() {
        return new IceShield();
    }
}
