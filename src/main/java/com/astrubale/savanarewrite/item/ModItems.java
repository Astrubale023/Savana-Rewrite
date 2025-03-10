package com.astrubale.savanarewrite.item;

import com.astrubale.savanarewrite.SavanaRewrite;
import com.astrubale.savanarewrite.entity.ModEntities;
import com.astrubale.savanarewrite.entity.custom.Ostrich;
import com.astrubale.savanarewrite.item.custom.GliderItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item GLIDER = registerItem("glider",
            new GliderItem(new FabricItemSettings().maxCount(1)));

    public static final Item GREAT_FEATHER = registerItem("great_feather", new Item(new FabricItemSettings()));

    public static final Item OSTRICH_SPAWN_EGG = registerItem("ostrich_spawn_egg",
            new SpawnEggItem(ModEntities.OSTRICH,0x948e8d, 0x3b3635,
                    new FabricItemSettings().maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(SavanaRewrite.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SavanaRewrite.LOGGER.info("Registering Mod Items for " + SavanaRewrite.MOD_ID);
    }
}
