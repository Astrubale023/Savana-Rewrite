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
        /*
        addDrop(ModBlocks.CHESTNUT_SAPLING);

        addDrop(ModBlocks.CHESTNUT_LEAVES, leavesDrops(ModBlocks.CHESTNUT_LEAVES, ModBlocks.CHESTNUT_SAPLING, 0.0025f)); // TODO
         */
    }
    /*
    public LootTable.Builder copperLikeOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                ((LeafEntry.Builder)
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction
                                        .builder(UniformLootNumberProvider
                                                .create(2.0f, 5.0f))))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
    */
}