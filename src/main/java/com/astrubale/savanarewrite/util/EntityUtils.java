package com.astrubale.savanarewrite.util;

import com.astrubale.savanarewrite.SavanaRewrite;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class EntityUtils {

    private static final TagKey<Block> INVALID_BONEMEAL_TARGETS = TagKey.of(Registries.BLOCK.getKey(), new Identifier(SavanaRewrite.MOD_ID, "invalid_bonemeal_targets"));

    public static List<BlockPos> getPositionalOffsets(int range) {
        ArrayList<BlockPos> offsets = new ArrayList<>();

        for (int i = 0; (double) i <= range; i = i > 0 ? -i : 1 - i) {
            for (int j = 0; (double) j < range; ++j) {
                for (int k = 0; k <= j; k = k > 0 ? -k : 1 - k) {
                    for (int l = k < j && k > -j ? j : 0; l <= j; l = l > 0 ? -l : 1 - l) {
                        offsets.add(new BlockPos(k, i - 1, l));
                    }
                }
            }
        }
        return offsets;
    }

    public static boolean validBoneMealTarget(World world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        if (state.getBlock() instanceof FarmlandBlock block && !state.isIn(INVALID_BONEMEAL_TARGETS)) {
            if (block.canPlaceAt(state, world, pos)) {
                if (world instanceof ServerWorld) {
                    //return block.isBonemealSuccess(world, world.random, pos, state);
                }
            }
        }
        return false;
    }
}
