package com.astrubale.savanarewrite;

import com.astrubale.savanarewrite.block.ModBlocks;
import com.astrubale.savanarewrite.entity.ModEntities;
import com.astrubale.savanarewrite.entity.client.model.OstrichModel;
import com.astrubale.savanarewrite.entity.client.renderer.OstrichRenderer;
import com.astrubale.savanarewrite.entity.client.renderer.TaiwanLionBossRenderer;
import com.astrubale.savanarewrite.entity.layer.ModModelLayer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

public class SavanaRewriteClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BAOBAB_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BAOBAB_SAPLING, RenderLayer.getCutout());

        // EntityRendererRegistry.register(ModEntities.OSTRICH, OstrichRenderer::new);
        EntityRendererRegistry.register(ModEntities.TAIWAN_LION_BOSS, TaiwanLionBossRenderer::new);

        EntityRendererRegistry.register(ModEntities.OSTRICH, OstrichRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayer.OSTRICH, OstrichModel::getTexturedModelData);
    }
}
