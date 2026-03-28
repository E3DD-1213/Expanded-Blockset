package com.e3dd.expandedblockset;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ExpandedBlockset.MOD_ID);

    public static final RegistryObject<Block> CAPPED_OAK_SLAB = registerCappedSlab("oak", Blocks.OAK_PLANKS);
    public static final RegistryObject<Block> CAPPED_SPRUCE_SLAB = registerCappedSlab("spruce", Blocks.SPRUCE_PLANKS);
    public static final RegistryObject<Block> CAPPED_BIRCH_SLAB = registerCappedSlab("birch", Blocks.BIRCH_PLANKS);
    public static final RegistryObject<Block> CAPPED_JUNGLE_SLAB = registerCappedSlab("jungle", Blocks.JUNGLE_PLANKS);
    public static final RegistryObject<Block> CAPPED_ACACIA_SLAB = registerCappedSlab("acacia", Blocks.ACACIA_PLANKS);
    public static final RegistryObject<Block> CAPPED_DARK_OAK_SLAB = registerCappedSlab("dark_oak", Blocks.DARK_OAK_PLANKS);
    public static final RegistryObject<Block> CAPPED_MANGROVE_SLAB = registerCappedSlab("mangrove", Blocks.MANGROVE_PLANKS);
    public static final RegistryObject<Block> CAPPED_CHERRY_SLAB = registerCappedSlab("cherry", Blocks.CHERRY_PLANKS);

    private static RegistryObject<Block> registerCappedSlab(String name, Block baseBlock) {
        return registerBlock("capped_" + name + "_slab",
                () -> new CappedOakSlabBlock(BlockBehaviour.Properties.copy(baseBlock).noOcclusion()));
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
