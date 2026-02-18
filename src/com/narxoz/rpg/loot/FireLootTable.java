package com.narxoz.rpg.loot;

import java.util.Arrays;
import java.util.List;

public class FireLootTable implements LootTable {
    private List<String> items = Arrays.asList("Fire Gem", "Dragon Scale", "Flame Rune");

    @Override
    public List<String> getItems() {
        return items;
    }

    @Override
    public int getGoldDrop() {
        return 500;
    }

    @Override
    public int getExperienceDrop() {
        return 1000;
    }

    @Override
    public LootTable clone() {
        FireLootTable copy = new FireLootTable();
        copy.items = Arrays.asList(items.toArray(new String[0]));
        return copy;
    }
}