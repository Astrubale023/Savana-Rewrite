package com.astrubale.savanarewrite.datagen;

import com.astrubale.savanarewrite.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {

        addDrop(ModBlocks.BAOBAB_LOG);
        addDrop(ModBlocks.BAOBAB_WOOD);
        addDrop(ModBlocks.STRIPPED_BAOBAB_LOG);
        addDrop(ModBlocks.STRIPPED_BAOBAB_WOOD);
        addDrop(ModBlocks.BAOBAB_PLANKS);
        addDrop(ModBlocks.BAOBAB_SAPLING);

        addDrop(ModBlocks.BAOBAB_LEAVES, leavesDrops(ModBlocks.BAOBAB_LEAVES, ModBlocks.BAOBAB_SAPLING, 0.0025f));
    }
}