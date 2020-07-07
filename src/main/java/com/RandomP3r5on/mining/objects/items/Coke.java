package com.RandomP3r5on.mining.objects.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Coke extends Item {
    public Coke(Properties properties) {
        super(properties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 3000;
    }
}
