package net.ari.mymod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab MYMOD_TAB = new CreativeModeTab("mytab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.BANANA.get());
        }
    };
}
