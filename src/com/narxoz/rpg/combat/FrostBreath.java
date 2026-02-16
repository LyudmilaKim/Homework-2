package com.narxoz.rpg.combat;

public class FrostBreath implements Ability {
    @Override
    public String getName() {
        return "Frost Breath";
    }

    @Override
    public int getDamage() {
        return 120;
    }

    @Override
    public String getDescription() {
        return "Breathes frost causing damage and slow effect.";
    }

    @Override
    public Ability clone() {
        return new FrostBreath();
    }
}