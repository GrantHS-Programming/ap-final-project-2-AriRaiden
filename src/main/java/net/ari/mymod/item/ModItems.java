package net.ari.mymod.item;

import net.ari.mymod.MyMod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MyMod.MOD_ID);

    public static final RegistryObject<Item> RAW_POTASSIUM = ITEMS.register("raw_potassium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MYMOD_TAB)));
    public static final RegistryObject<Item> BANANA = ITEMS.register("banana",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MYMOD_TAB).food(Foods.BANANA)));

    public static class Foods {
        public static final FoodProperties BANANA = new FoodProperties.Builder()
                .nutrition(2)
                .saturationMod(1.3f)
                .fast()
                .build();
    }

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
