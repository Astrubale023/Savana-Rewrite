package com.astrubale.savanarewrite.datagen;

import com.astrubale.savanarewrite.block.ModBlocks;
import com.astrubale.savanarewrite.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.BAOBAB_PLANKS.asItem(), 4)
                .pattern("L")
                .input('L', ModBlocks.BAOBAB_LOG)
                .criterion(hasItem(ModBlocks.BAOBAB_LOG.asItem()), conditionsFromItem(ModBlocks.BAOBAB_LOG.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BAOBAB_PLANKS.asItem())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.BAOBAB_PLANKS.asItem(), 4)
                .pattern("L")
                .input('L', ModBlocks.STRIPPED_BAOBAB_LOG)
                .criterion(hasItem(ModBlocks.STRIPPED_BAOBAB_LOG.asItem()), conditionsFromItem(ModBlocks.STRIPPED_BAOBAB_LOG.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.STRIPPED_BAOBAB_LOG.asItem())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GLIDER, 1)
                .pattern("FFF")
                .pattern("S S")
                .input('F', Items.FEATHER)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.FEATHER), conditionsFromItem(Items.FEATHER))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GLIDER)));
    }
}