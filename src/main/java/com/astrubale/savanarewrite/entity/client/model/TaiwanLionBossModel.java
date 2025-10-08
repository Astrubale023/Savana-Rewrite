package com.astrubale.savanarewrite.entity.client.model;

import com.astrubale.savanarewrite.SavanaRewrite;
import com.astrubale.savanarewrite.entity.custom.TaiwanLionBoss;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class TaiwanLionBossModel extends GeoModel<TaiwanLionBoss> {
    @Override
    public Identifier getModelResource(TaiwanLionBoss animatable) {
        return new Identifier(SavanaRewrite.MOD_ID, "geo/taiwan_lion_boss.geo.json");
    }

    @Override
    public Identifier getTextureResource(TaiwanLionBoss animatable) {
        return new Identifier(SavanaRewrite.MOD_ID, "taiwan_lion_boss.png");
    }

    @Override
    public Identifier getAnimationResource(TaiwanLionBoss animatable) {
        return new Identifier(SavanaRewrite.MOD_ID, "animations/taiwan_lion_boss.animation.json");
    }
}
