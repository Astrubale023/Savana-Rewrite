package com.astrubale.savanarewrite.entity.client.renderer;

import com.astrubale.savanarewrite.SavanaRewrite;
import com.astrubale.savanarewrite.entity.client.model.OstrichModel;
import com.astrubale.savanarewrite.entity.custom.Ostrich;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class OstrichRenderer extends GeoEntityRenderer<Ostrich> {
    public OstrichRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new OstrichModel());
    }

    @Override
    public Identifier getTextureLocation(Ostrich animatable) {
        return new Identifier(SavanaRewrite.MOD_ID, "textures/entity/ostrich/ostrich.png");
    }
}
