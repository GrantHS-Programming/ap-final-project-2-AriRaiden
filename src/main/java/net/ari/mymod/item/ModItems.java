package net.ari.mymod.item;

import net.ari.mymod.MyMod;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
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
            () -> new Item(props()));
    public static final RegistryObject<Item> BANANA = ITEMS.register("banana",
            () -> new Item(props()));

    public static final RegistryObject<ArmorItem> BANANA_HELMET = ITEMS.register("banana_helmet",
            () -> new ArmorItem(null, EquipmentSlot.HEAD, props()));
    public static final RegistryObject<ArmorItem> BANANA_CHESTPLATE = ITEMS.register("banana_chestplate",
            () -> new ArmorItem(null, EquipmentSlot.CHEST, props()));
    public static final RegistryObject<ArmorItem> BANANA_LEGGINGS = ITEMS.register("banana_leggings",
            () -> new ArmorItem(null, EquipmentSlot.LEGS, props()));
    public static final RegistryObject<ArmorItem> BANANA_BOOTS = ITEMS.register("banana_boots",
            () -> new ArmorItem(null, EquipmentSlot.FEET, props()));


    public static Item.Properties props() {
        return new Item.Properties().tab(ModCreativeModeTab.MYMOD_TAB);
    }
    public static class Foods {
        public static final FoodProperties BANANA = new FoodProperties.Builder()
                .nutrition(2)
                .saturationMod(1.3f)
                .fast()
                .build();
    }

    public static class ArmorTiers {

    }



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
