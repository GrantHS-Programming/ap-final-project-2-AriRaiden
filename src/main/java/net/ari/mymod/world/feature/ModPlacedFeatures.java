package net.ari.mymod.world.feature;

import net.ari.mymod.MyMod;
import net.ari.mymod.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, MyMod.MOD_ID);

    public static final RegistryObject<PlacedFeature> POTASSIUM_ORE_PLACED = PLACED_FEATURES.register("potassium_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.POTASSIUM_ORE.getHolder().get(),
                    commonOrePlacement(16, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-32), VerticalAnchor.aboveBottom(112))))); //most common at y = 40

    public static final RegistryObject<PlacedFeature> BANANA_TREE_CHECKED = PLACED_FEATURES.register("banana_tree_checked",
            () -> new PlacedFeature(ModConfiguredFeatures.BANANA_TREE.getHolder().get(),
                    List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.BANANA_SAPLING.get()))));

    public static final RegistryObject<PlacedFeature> BANANA_TREE_PLACED = PLACED_FEATURES.register("banana_tree_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.BANANA_TREE_SPAWN.getHolder().get(), VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(3, .1f, 2))));

    private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    private static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

    public static void register(IEventBus eventBus){
        PLACED_FEATURES.register(eventBus);
    }
}
