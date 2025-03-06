package com.astrubale.savanarewrite.world.gen;

import net.minecraft.world.gen.GenerationStep;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        // Pay attention to the order, check GenerationStep class under the enum Feature
        //ModOreGeneration.generateOres();
        ModTreeGeneration.generateTrees();
        ModEntitySpawn.addEntitySpawn();
    }
}