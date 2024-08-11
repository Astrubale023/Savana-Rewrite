package com.astrubale.savanarewrite.entity.goal;

import com.astrubale.savanarewrite.util.EntityUtils;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.BlockPos;

import java.util.List;

public class FindWaterGoal extends Goal {

    private static final List<BlockPos> POSITIONAL_OFFSET = EntityUtils.getPositionalOffsets(12);

    @Override
    public boolean canStart() {
        return false;
    }
}
