package com.astrubale.savanar.item;

import com.astrubale.savanar.SavanaRewrite;
import com.astrubale.savanar.block.ModBlocks;
import net.astrubale.testmod.TestMod;
import net.astrubale.testmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup WOODDERS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(SavanaRewrite.MOD_ID, "savanar"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.savanar"))
                    .icon(() -> new ItemStack(ModBlocks.BAOBAB_LOG.asItem())).entries((displayContext, entries) -> {

                        entries.add(ModBlocks.BAOBAB_LOG);
                        entries.add(ModBlocks.BAOBAB_WOOD);
                        entries.add(ModBlocks.STRIPPED_BAOBAB_LOG);
                        entries.add(ModBlocks.STRIPPED_BAOBAB_WOOD);
                        entries.add(ModBlocks.BAOBAB_PLANKS);
                        /*
                        entries.add(ModBlocks.CHESTNUT_LEAVES);
                        entries.add(ModBlocks.CHESTNUT_SAPLING);
                         */


                    }).build());


    public static void registerItemGroups() {
        SavanaRewrite.LOGGER.info("Registering Item Groups for " + SavanaRewrite.MOD_ID);
    }
}