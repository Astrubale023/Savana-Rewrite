package com.astrubale.savanarewrite.entity.goal;

import com.astrubale.savanarewrite.entity.custom.Elephanty;
import com.astrubale.savanarewrite.util.EntityUtils;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

import java.util.EnumSet;
import java.util.List;

public class DrinkWaterGoal extends Goal {

    private int drinkTimer;
    private final int timerCap;

    private final Elephanty elephanty;
    private static final List<BlockPos> POSITIONAL_OFFSETS = EntityUtils.getPositionalOffsets(1);

    public DrinkWaterGoal(Elephanty elephant, int timeInSeconds) {
        this.setControls(EnumSet.of(Control.MOVE, Control.TARGET, Control.LOOK));
        this.elephanty = elephant;
        this.timerCap = timeInSeconds * 20;
    }

    @Override
    public boolean canStart() {
        if(elephanty.getOwner() != null && !elephanty.hasWater()) {
            return !elephanty.isWatering() && !elephanty.hasWater() && elephanty.isNearWater() && checkForWater();
        }
        return false;
    }

    @Override
    public void start() {
        super.start();
        drinkTimer = 0;
        elephanty.lookAt(elephanty.getCommandSource().getEntityAnchor(), Vec3d.ofCenter(elephanty.getWaterPos()));
        elephanty.setDrinking(true);
    }

    @Override
    public void tick() {
        super.tick();
        elephanty.lookAt(elephanty.getCommandSource().getEntityAnchor(), Vec3d.ofCenter(elephanty.getWaterPos()));
    }

    @Override
    public boolean shouldContinue() {
        return checkForWater() && drinkTimer++ <= timerCap && elephanty.isNearWater();
    }

    @Override
    public void stop() {
        super.stop();
        elephanty.setDrinking(false);
        elephanty.setWaterPos(null);
        if(drinkTimer >= timerCap) elephanty.setIfHasWater(true);
    }

    public boolean checkForWater() {
        BlockPos.Mutable waterPos = elephanty.getBlockPos().mutableCopy();
        for (BlockPos blockPos : POSITIONAL_OFFSETS){
            //prossima stringa potrebbe essere molto diversa dall'originale
            waterPos.offset(elephanty.getMovementDirection(), (int) blockPos.getSquaredDistance(elephanty.getBlockPos()));
            if (this.elephanty.getWorld().isWater(waterPos)){
                return true;
            }
        }
        return false;
    }
}
