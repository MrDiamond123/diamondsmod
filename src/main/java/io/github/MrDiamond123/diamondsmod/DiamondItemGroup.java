package io.github.MrDiamond123.diamondsmod;

import io.github.MrDiamond123.diamondsmod.lists.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class DiamondItemGroup extends ItemGroup {

    public DiamondItemGroup()
    {
        super("diamond");
    }
    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemList.crystaline_shard);
    }
}
