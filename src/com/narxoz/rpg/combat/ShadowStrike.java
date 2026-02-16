package com.narxoz.rpg.combat;

public class ShadowStrike implements Ability {
    @Override
    public String getName() {
        return "Shadow Strike";
    }

    @Override
    public int getDamage() {
        return 180;
    }

    @Override
    public String getDescription() {
        return "Strikes from shadows with high single-target damage and blind.";
    }

    @Override
    public Ability clone() {
        return new ShadowStrike();
    }
}