package com.narxoz.rpg.combat;

public class Blizzard implements Ability {
    @Override
    public String getName() {
        return "Blizzard";
    }

    @Override
    public int getDamage() {
        return 250;
    }

    @Override
    public String getDescription() {
        return "Summons a blizzard for AoE damage and freeze.";
    }

    @Override
    public Ability clone() {
        return new Blizzard();
    }
}