package com.astrubale.savanarewrite.data;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.jetbrains.annotations.NotNull;

public class GliderData {

    @NotNull
    private final PlayerEntity player;
    public AnimationState glideAnimation = new AnimationState();
    public AnimationState gliderOpeningAnimation = new AnimationState();
    private boolean isGliding = false;

    public GliderData(@NotNull PlayerEntity player) {
        this.player = player;
    }

    public boolean isGliding() {
        return isGliding;
    }

    private void setGliding(boolean glidingWithActiveGlider) {
        isGliding = glidingWithActiveGlider;
    }

    /*
    public void tick(LivingEntity livingEntity) {
        glideAndFallLogic(livingEntity);
        GliderUtil.onTickPlayerGlide(livingEntity.level, livingEntity);

        if(!GliderUtil.isGlidingWithActiveGlider(livingEntity)){
            setLightningTimer(0);
        }

        if (livingEntity.level.isClientSide) return;
        setGliding(GliderUtil.isGlidingWithActiveGlider(livingEntity));

        if (livingEntity.tickCount % 40 == 0) {
            sync();
        }
    }

    private void glideAndFallLogic(LivingEntity livingEntity) {
        if (isGliding() || GliderUtil.isGlidingWithActiveGlider(livingEntity)) {
            if (!glideAnimation.isStarted()) {
                glideAnimation.start(livingEntity.tickCount);
            }

            if (!gliderOpeningAnimation.isStarted()) {
                gliderOpeningAnimation.start(livingEntity.tickCount);
            }
        } else {
            glideAnimation.stop();
            gliderOpeningAnimation.stop();
        }
    }
    */
}
