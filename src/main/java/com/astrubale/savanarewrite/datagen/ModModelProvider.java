package com.astrubale.savanarewrite.datagen;

import com.astrubale.savanarewrite.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerLog(ModBlocks.BAOBAB_LOG).log(ModBlocks.BAOBAB_LOG).wood(ModBlocks.BAOBAB_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_BAOBAB_LOG).log(ModBlocks.STRIPPED_BAOBAB_LOG).wood(ModBlocks.STRIPPED_BAOBAB_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BAOBAB_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BAOBAB_LEAVES);
        blockStateModelGenerator.registerTintableCross(ModBlocks.BAOBAB_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    }
}