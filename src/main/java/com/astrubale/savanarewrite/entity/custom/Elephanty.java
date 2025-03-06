package com.astrubale.savanarewrite.entity.custom;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EntityView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

public class Elephanty extends TameableEntity implements GeoEntity, Herbivore {

    protected static final TrackedData<Boolean> DRINKING = DataTracker.registerData(Elephanty.class, TrackedDataHandlerRegistry.BOOLEAN);
    protected static final TrackedData<Boolean> WATERING = DataTracker.registerData(Elephanty.class, TrackedDataHandlerRegistry.BOOLEAN);
    protected static final TrackedData<Boolean> HAS_WATER = DataTracker.registerData(Elephanty.class, TrackedDataHandlerRegistry.BOOLEAN);

    @Nullable
    private BlockPos waterPos;
    private BlockPos plantPos;

    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    protected Elephanty(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    /* NBT DATA TRACKER */

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(DRINKING, false);
        this.dataTracker.startTracking(WATERING, false);
        this.dataTracker.startTracking(HAS_WATER, false);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        dataTracker.set(DRINKING, nbt.getBoolean("Drinking"));
        dataTracker.set(WATERING, nbt.getBoolean("Watering"));
        dataTracker.set(HAS_WATER, nbt.getBoolean("HasWater"));
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("Drinking", dataTracker.get(DRINKING));
        nbt.putBoolean("Watering", dataTracker.get(WATERING));
        nbt.putBoolean("HasWater", dataTracker.get(HAS_WATER));
    }

    /* IS +ING */
    public boolean isDrinking() {
        return this.dataTracker.get(DRINKING);
    }

    public boolean isWatering() {
        return this.dataTracker.get(WATERING);
    }

    public boolean hasWater() {
        return this.dataTracker.get(HAS_WATER);
    }

    /* WATER METHODS */
    @Nullable
    public BlockPos getWaterPos() {
        return waterPos;
    }

    public void setWaterPos(@Nullable BlockPos waterPos) {
        this.waterPos = waterPos;
    }

    public boolean isNearWater() {
        return isNearBlock(getWaterPos(), 1);
    }

    public boolean isNearBlock(BlockPos pos, int range) {
        return pos != null && pos.getSquaredDistance(this.getPositionTarget()) < range * range;
    }

    public boolean isNearPlant() {
        return isNearBlock(getTargetPlant(), 3);
    }

    /* SETTER */
    public void setDrinking(boolean bool) {
        this.dataTracker.set(DRINKING, bool);
    }

    public void setWatering(boolean bool) {
        this.dataTracker.set(WATERING, bool);
    }

    public void setIfHasWater(boolean bool) {
        this.dataTracker.set(HAS_WATER, bool);
    }

    /* OTHER */
    @Override
    public boolean isNotBusy() {
        return !(this.isDrinking() || this.isSitting() || this.isWatering());
    }

    @Override
    public void setTargetPlant(BlockPos pos) {
        this.plantPos = pos;
    }

    @Override
    public @Nullable BlockPos getTargetPlant() {
        return plantPos;
    }

    /* TAMEABLE METHOD */
    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    @Override
    public EntityView method_48926() {
        return this.getWorld();
    }

    /* GECKOLIB METHOD */
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.geoCache;
    }
}
