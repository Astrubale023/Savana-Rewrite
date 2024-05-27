package com.astrubale.savanarewrite.datagen;

import com.astrubale.savanarewrite.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.BAOBAB_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.BAOBAB_LOG.asItem())
                .add(ModBlocks.BAOBAB_WOOD.asItem())
                .add(ModBlocks.STRIPPED_BAOBAB_LOG.asItem())
                .add(ModBlocks.STRIPPED_BAOBAB_WOOD.asItem());
    }
}
