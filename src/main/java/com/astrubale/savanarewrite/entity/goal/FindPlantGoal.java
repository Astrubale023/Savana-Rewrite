package com.astrubale.savanarewrite.entity.goal;

import com.astrubale.savanarewrite.entity.custom.Elephanty;
import com.astrubale.savanarewrite.entity.custom.Herbivore;
import com.astrubale.savanarewrite.util.EntityUtils;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.Tameable;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.pathing.PathNodeNavigator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.EnumSet;
import java.util.List;
import java.util.function.BiPredicate;

public class FindPlantGoal<T extends Tameable & Herbivore> extends Goal {

    private static final List<BlockPos> POSITIONAL_OFFSETS = EntityUtils.getPositionalOffsets(12);

    private final T herbivore;
    public final BiPredicate<World, BlockPos> blockPredicate;

    private BlockPos targetPosition;

    public FindPlantGoal(T herbivore, BiPredicate<World, BlockPos> blockPredicate) {
        this.setControls(EnumSet.of(Control.MOVE, Control.TARGET, Control.LOOK));
        this.herbivore = herbivore;
        this.blockPredicate = blockPredicate;
    }

    @Override
    public boolean canStart() {
        if(herbivore.isNotBusy() && herbivore.getOwner() != null && herbivore.specialPredicate()) {
            findNearbyPlant();
            return targetPosition != null && Math.sqrt(targetPosition.getSquaredDistance(herbivore.blockPosition())) - 1 >= 1; //nel git hub invece di getTargetPlant() c'è blockPosition()
        }
        return false;
    }

    @Override
    public boolean shouldContinue() {
        return targetPosition != null && Math.sqrt(targetPosition.getSquaredDistance(herbivore.blockPosition())) - 1 >= 1; //nel git hub invece di getTargetPlant() c'è blockPosition()
    }

    // GUARDARE LA CLASSE BEE E ANCHE I SUOI GOAL
    // MAGARI DIVIDERE I GOAL IN TROVA E MUOVITI, COME PER L'APE

    @Override
    public void start() {
        super.start();
        if(targetPosition != null) {
            Path nav = herbivore.getNavigation();
            nav.moveTo(targetPosition.getX() + 0.5, targetPosition.getY() + 0.75, targetPosition.getZ() + 0.5, 0.3);
        }
    }

    @Override
    public void stop() {
        super.stop();
        herbivore.setTargetPlant(targetPosition);
        targetPosition = null;
    }

    public void findNearbyPlant() {
        if(targetPosition != null) return;
        BlockPos.Mutable plantPos = herbivore.blockPosition.mutable();
        for (BlockPos blockPos : POSITIONAL_OFFSETS) {
            plantPos.offset(herbivore.getDirection(), blockPos);
            if(blockPredicate.test(herbivore.getWorl(), plantPos)) {
                Path path = herbivore.getNavigation().createPath(plantPos, 0);
                if(path != null && path.canReach()) {
                    this.targetPosition = path.getTarget();
                    return;
                }
            }
        }
    }
}
