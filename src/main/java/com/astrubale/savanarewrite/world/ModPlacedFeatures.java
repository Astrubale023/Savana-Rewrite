package com.astrubale.savanarewrite.world;

import com.astrubale.savanarewrite.SavanaRewrite;
import com.astrubale.savanarewrite.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> BAOBAB_PLACED_KEY = registerKey("baobab_placed");

    public static void boostrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, BAOBAB_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BAOBAB_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive( // Look at the VegetationPlacedFeatures class and the different TREES implementing the next used method
                        PlacedFeatures.createCountExtraModifier(2, 0.1f, 2), //extraChance has to be a divisor of 1, so 1/chance=Int(not float), check the method
                        ModBlocks.BAOBAB_SAPLING));   //WouldSurvive with a Sapling check if a sapling would spawn a tree in that block
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(SavanaRewrite.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}