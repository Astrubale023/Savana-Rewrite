package com.astrubale.savanarewrite.item;

import com.astrubale.savanarewrite.SavanaRewrite;
import com.astrubale.savanarewrite.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup SAVANA_REWRITE_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(SavanaRewrite.MOD_ID, "savanarewrite"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.savanarewrite"))
                    .icon(() -> new ItemStack(ModBlocks.BAOBAB_LOG.asItem())).entries((displayContext, entries) -> {

                        entries.add(ModBlocks.BAOBAB_LOG);
                        entries.add(ModBlocks.BAOBAB_WOOD);
                        entries.add(ModBlocks.STRIPPED_BAOBAB_LOG);
                        entries.add(ModBlocks.STRIPPED_BAOBAB_WOOD);
                        entries.add(ModBlocks.BAOBAB_PLANKS);
                        entries.add(ModBlocks.BAOBAB_LEAVES);
                        entries.add(ModBlocks.BAOBAB_SAPLING);

                        entries.add(ModItems.GLIDER);

                    }).build());


    public static void registerItemGroups() {
        SavanaRewrite.LOGGER.info("Registering Item Groups for " + SavanaRewrite.MOD_ID);
    }
}