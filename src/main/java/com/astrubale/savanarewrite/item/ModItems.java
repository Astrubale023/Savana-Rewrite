package com.astrubale.savanarewrite.item;

import com.astrubale.savanarewrite.SavanaRewrite;
import com.astrubale.savanarewrite.item.custom.GliderItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item GLIDER = registerItem("glider",
            new GliderItem(new FabricItemSettings().maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(SavanaRewrite.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SavanaRewrite.LOGGER.info("Registering Mod Items for " + SavanaRewrite.MOD_ID);

        // ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
