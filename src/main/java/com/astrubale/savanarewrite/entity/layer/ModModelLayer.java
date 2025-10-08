package com.astrubale.savanarewrite.entity.layer;

import com.astrubale.savanarewrite.SavanaRewrite;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayer {
    public static final EntityModelLayer OSTRICH = new EntityModelLayer(new Identifier(SavanaRewrite.MOD_ID, "ostrich"), "main");
}
