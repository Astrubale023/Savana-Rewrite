package com.astrubale.savanarewrite;

import com.astrubale.savanarewrite.block.ModBlocks;
import com.astrubale.savanarewrite.item.ModItemGroups;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SavanaRewrite implements ModInitializer {
	public static final String MOD_ID = "savanarewrite";
    public static final Logger LOGGER = LoggerFactory.getLogger("savanarewrite");

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModBlocks.registerModBlocks();

		StrippableBlockRegistry.register(ModBlocks.BAOBAB_LOG, ModBlocks.STRIPPED_BAOBAB_LOG);
		StrippableBlockRegistry.register(ModBlocks.BAOBAB_WOOD, ModBlocks.STRIPPED_BAOBAB_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BAOBAB_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BAOBAB_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_BAOBAB_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_BAOBAB_WOOD, 5, 5);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BAOBAB_PLANKS, 5, 20);

		LOGGER.info("Hello Fabric world!");
	}
}