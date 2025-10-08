package com.astrubale.savanarewrite.entity.client.renderer;

import com.astrubale.savanarewrite.SavanaRewrite;
import com.astrubale.savanarewrite.entity.client.model.TaiwanLionBossModel;
import com.astrubale.savanarewrite.entity.custom.TaiwanLionBoss;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TaiwanLionBossRenderer extends GeoEntityRenderer<TaiwanLionBoss> {
    public TaiwanLionBossRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new TaiwanLionBossModel());
    }

    @Override
    public Identifier getTextureLocation(TaiwanLionBoss animatable) {
        return new Identifier(SavanaRewrite.MOD_ID, "textures/entity/taiwan_lion/taiwan_lion_boss.png");
    }
}
