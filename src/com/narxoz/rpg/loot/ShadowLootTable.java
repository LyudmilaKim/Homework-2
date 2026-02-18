package com.narxoz.rpg.loot;

import java.util.Arrays;
import java.util.List;

public class ShadowLootTable implements LootTable {
    private List<String> items = Arrays.asList("Shadow Gem", "Dark Essence", "Shadow Rune");

    @Override
    public List<String> getItems() {
        return items;
    }

    @Override
    public int getGoldDrop() {
        return 600;
    }

    @Override
    public int getExperienceDrop() {
        return 1200;
    }

    @Override
    public LootTable clone() {
        ShadowLootTable copy = new ShadowLootTable();
        copy.items = Arrays.asList(items.toArray(new String[0]));
        return copy;
    }
}