package com.narxoz.rpg.combat;

public class DarkNova implements Ability {
    @Override
    public String getName() {
        return "Dark Nova";
    }

    @Override
    public int getDamage() {
        return 280;
    }

    @Override
    public String getDescription() {
        return "Explodes dark energy for AoE damage.";
    }

    @Override
    public Ability clone() {
        return new DarkNova();
    }
}