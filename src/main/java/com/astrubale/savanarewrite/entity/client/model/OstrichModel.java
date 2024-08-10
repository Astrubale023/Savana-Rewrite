package com.astrubale.savanarewrite.entity.client.model;

import com.astrubale.savanarewrite.SavanaRewrite;
import com.astrubale.savanarewrite.entity.custom.Ostrich;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class OstrichModel extends GeoModel<Ostrich> {
    @Override
    public Identifier getModelResource(Ostrich animatable) {
        return new Identifier(SavanaRewrite.MOD_ID, "geo/ostrich.geo.json");
    }

    @Override
    public Identifier getTextureResource(Ostrich animatable) {
        return new Identifier(SavanaRewrite.MOD_ID, "textures/entity/ostrich/ostrich.png");
    }

    @Override
    public Identifier getAnimationResource(Ostrich animatable) {
        return new Identifier(SavanaRewrite.MOD_ID, "animations/ostrich.animation.json");
    }
}
