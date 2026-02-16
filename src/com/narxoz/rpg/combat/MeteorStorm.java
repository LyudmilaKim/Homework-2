package com.narxoz.rpg.combat;

public class MeteorStorm implements Ability {
    @Override
    public String getName() {
        return "Meteor Storm";
    }

    @Override
    public int getDamage() {
        return 300;
    }

    @Override
    public String getDescription() {
        return "Summons meteors for high AoE damage.";
    }

    @Override
    public Ability clone() {
        return new MeteorStorm();
    }
}