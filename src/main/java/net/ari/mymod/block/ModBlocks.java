package net.ari.mymod.block;

//import jdk.incubator.vector.VectorOperators;
import net.ari.mymod.MyMod;
import net.ari.mymod.base.ModFlammableRotatedPillarBlock;
import net.ari.mymod.item.ModCreativeModeTab;
import net.ari.mymod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MyMod.MOD_ID);

    public static final RegistryObject<Block> BLOCK_OF_BANANA = registerBlock("block_of_banana",
            () -> new IceBlock(BlockBehaviour
                    .Properties
                    .of(Material.ICE)
                    .strength(1.4f)), ModCreativeModeTab.MYMOD_TAB);

    public static final RegistryObject<Block> POTASSIUM_ORE = registerBlock("potassium_ore",
            () -> new DropExperienceBlock(BlockBehaviour
                    .Properties
                    .of(Material.STONE)
                    .strength(3f)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(1, 3)), ModCreativeModeTab.MYMOD_TAB);
    public static final RegistryObject<Block> DEEPSLATE_POTASSIUM_ORE = registerBlock("deepslate_potassium_ore",
            () -> new DropExperienceBlock(BlockBehaviour
                    .Properties
                    .of(Material.STONE)
                    .strength(4f)
                    .requiresCorrectToolForDrops(),
                    UniformInt.of(1, 3)), ModCreativeModeTab.MYMOD_TAB);

    //BANANA TREE
    public static final RegistryObject<Block> BANANA_LOG = registerBlock("banana_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour
                    .Properties
                    .copy(Blocks.OAK_LOG)
                    .requiresCorrectToolForDrops()),
                     ModCreativeModeTab.MYMOD_TAB);
    public static final RegistryObject<Block> BANANA_WOOD = registerBlock("banana_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour
                    .Properties
                    .copy(Blocks.OAK_WOOD)
                    .requiresCorrectToolForDrops()),
            ModCreativeModeTab.MYMOD_TAB);
    public static final RegistryObject<Block> STRIPPED_BANANA_LOG = registerBlock("stripped_banana_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour
                    .Properties
                    .copy(Blocks.STRIPPED_OAK_LOG)
                    .requiresCorrectToolForDrops()),
            ModCreativeModeTab.MYMOD_TAB);
    public static final RegistryObject<Block> STRIPPED_BANANA_WOOD = registerBlock("stripped_banana_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour
                    .Properties
                    .copy(Blocks.STRIPPED_OAK_WOOD)
                    .requiresCorrectToolForDrops()),
            ModCreativeModeTab.MYMOD_TAB);

    public static final RegistryObject<Block> BANANA_PLANKS = registerBlock("banana_planks",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour
                    .Properties
                    .copy(Blocks.OAK_PLANKS)
                    .requiresCorrectToolForDrops()) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            },
            ModCreativeModeTab.MYMOD_TAB);
    public static final RegistryObject<Block> BANANA_LEAVES = registerBlock("banana_leaves",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour
                    .Properties
                    .copy(Blocks.OAK_LEAVES)
                    .requiresCorrectToolForDrops()) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            },
            ModCreativeModeTab.MYMOD_TAB);

//    public static final RegistryObject<Block> BANANA_SAPLING = registerBlock("banana_log",
//            () -> new SaplingBlock( ,BlockBehaviour
//                    .Properties
//                    .copy(Blocks.OAK_SAPLING)),
//            ModCreativeModeTab.MYMOD_TAB);



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static  <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                             CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
