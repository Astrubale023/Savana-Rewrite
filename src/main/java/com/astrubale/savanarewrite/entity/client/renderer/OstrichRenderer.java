package com.astrubale.savanarewrite.entity.client.renderer;

import com.astrubale.savanarewrite.SavanaRewrite;
import com.astrubale.savanarewrite.entity.client.model.OstrichModel;
import com.astrubale.savanarewrite.entity.custom.OstrichEntity;
import com.astrubale.savanarewrite.entity.layer.ModModelLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class OstrichRenderer extends MobEntityRenderer<OstrichEntity, OstrichModel<OstrichEntity>> {

    private static final Identifier TEXTURE = new Identifier(SavanaRewrite.MOD_ID, "textures/entity/ostrich/ostrich2.png");

    public OstrichRenderer(EntityRendererFactory.Context context) {
        super(context, new OstrichModel<>(context.getPart(ModModelLayer.OSTRICH)), 0.6f);
    }

    @Override
    public Identifier getTexture(OstrichEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(OstrichEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
