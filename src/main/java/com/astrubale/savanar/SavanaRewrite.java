package com.astrubale.savanar;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SavanaRewrite implements ModInitializer {
	public static final String MOD_ID = "savana_revenge";
    public static final Logger LOGGER = LoggerFactory.getLogger("savanar");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
	}
}