package com.narxoz.rpg.combat;

public class FlameBreath implements Ability {
    @Override
    public String getName() {
        return "Flame Breath";
    }

    @Override
    public int getDamage() {
        return 150;
    }

    @Override
    public String getDescription() {
        return "Breathes fire causing AoE damage and burn effect.";
    }

    @Override
    public Ability clone() {
        return new FlameBreath();
    }
}