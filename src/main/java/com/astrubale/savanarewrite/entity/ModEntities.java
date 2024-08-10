package com.astrubale.savanarewrite.entity;

import com.astrubale.savanarewrite.SavanaRewrite;
import com.astrubale.savanarewrite.entity.custom.Ostrich;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModEntities {
    public static final EntityType<Ostrich> OSTRICH = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(SavanaRewrite.MOD_ID, "ostrich"),
            EntityType.Builder.create(Ostrich::new, SpawnGroup.CREATURE).setDimensions(1f,1.625f).build());
}
