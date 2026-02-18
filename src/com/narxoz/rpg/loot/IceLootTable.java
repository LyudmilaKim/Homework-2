package com.narxoz.rpg.loot;

import java.util.Arrays;
import java.util.List;

public class IceLootTable implements LootTable {
    private List<String> items = Arrays.asList("Ice Gem", "Frost Scale", "Ice Rune");

    @Override
    public List<String> getItems() {
        return items;
    }

    @Override
    public int getGoldDrop() {
        return 400;
    }

    @Override
    public int getExperienceDrop() {
        return 800;
    }

    @Override
    public LootTable clone() {
        IceLootTable copy = new IceLootTable();
        copy.items = Arrays.asList(items.toArray(new String[0]));
        return copy;
    }
}