package com.astrubale.savanarewrite.block;

import com.astrubale.savanarewrite.SavanaRewrite;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block BAOBAB_LOG = registerBlock("baobab_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(4f)));
    public static final Block BAOBAB_WOOD = registerBlock("baobab_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(4f)));
    public static final Block STRIPPED_BAOBAB_LOG = registerBlock("stripped_baobab_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).strength(4f)));
    public static final Block STRIPPED_BAOBAB_WOOD = registerBlock("stripped_baobab_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(4f)));

    public static final Block BAOBAB_PLANKS = registerBlock("baobab_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f)));
    public static final Block BAOBAB_LEAVES = registerBlock("baobab_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).strength(4f).nonOpaque()));
/*
    public static final Block CHESTNUT_SAPLING = registerBlock("chestnut_sapling",
            new SaplingBlock(ModSaplingGenerators.CHESTNUT, FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
*/
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(SavanaRewrite.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(SavanaRewrite.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        SavanaRewrite.LOGGER.info("Registering ModBlocks for " + SavanaRewrite.MOD_ID);
    }
}
