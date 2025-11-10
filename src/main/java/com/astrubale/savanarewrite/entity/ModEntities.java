package com.astrubale.savanarewrite.entity;

import com.astrubale.savanarewrite.SavanaRewrite;
import com.astrubale.savanarewrite.entity.custom.OstrichEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModEntities {
    public static final EntityType<OstrichEntity> OSTRICH = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(SavanaRewrite.MOD_ID, "ostrich"),
            EntityType.Builder.create(OstrichEntity::new, SpawnGroup.CREATURE).setDimensions(1f,1.625f).build());
}
