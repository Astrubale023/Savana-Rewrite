package com.astrubale.savanarewrite.world.tree;

import com.astrubale.savanarewrite.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGenerators { //1.20.4 changed from 1.20.2
    public static final SaplingGenerator BAOBAB =
            new SaplingGenerator("chestnut", 0f, Optional.empty(),
                    Optional.empty(),
                    Optional.of(ModConfiguredFeatures.BAOBAB_KEY),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty());
}