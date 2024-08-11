package com.astrubale.savanarewrite.entity.goal;

import com.astrubale.savanarewrite.entity.custom.Elephanty;
import com.astrubale.savanarewrite.util.EntityUtils;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.ai.pathing.PathNodeNavigator;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.List;

public class FindWaterGoal extends Goal {

    private static final List<BlockPos> POSITIONAL_OFFSET = EntityUtils.getPositionalOffsets(12);

    private final Elephanty elephanty;
    @Nullable
    private BlockPos targetPosition;

    public FindWaterGoal(Elephanty elephanty) {
        this.setControls(EnumSet.of(Control.MOVE, Control.TARGET, Control.LOOK));
        this.elephanty = elephanty;
    }


    @Override
    public boolean canStart() {
        if(elephanty.getOwner() != null && !elephanty.hasWater()) {
            findWaterSource();
            return targetPosition != null && elephanty.isNotBusy() && targetPosition.getSquaredDistance(elephanty.getBlockPos()) > 1;
        }
        return false;
    }

    @Override
    public void start() {
        super.start();
        if(targetPosition != null) {
            EntityNavigation nav = elephanty.getNavigation();
            nav.startMovingTo(targetPosition.getX() + 0.5, targetPosition.getY() + 0.75, targetPosition.getZ() + 0.5, 0.3);
        }
    }

    @Override
    public boolean shouldContinue() {
        return targetPosition != null && targetPosition.getSquaredDistance(elephanty.getBlockPos()) > 1;
    }

    @Override
    public void stop() {
        super.stop();
        elephanty.setWaterPos(targetPosition);
        targetPosition = null;
    }

    public void findWaterSource() {
        if(targetPosition != null) return;
        BlockPos.Mutable waterPos = elephanty.getBlockPos().mutableCopy();
        for (BlockPos blockPos : POSITIONAL_OFFSET){
            //prossima stringa potrebbe essere molto diversa dall'originale
            waterPos.offset(elephanty.getMovementDirection(), (int) blockPos.getSquaredDistance(elephanty.getBlockPos()));
            if (this.elephanty.getWorld().isWater(waterPos)){
                Path path = elephanty.getNavigation().findPathTo(waterPos, 1);
                this.targetPosition = path == null ? null : path.getTarget();
                return;
            }
        }
    }
}
