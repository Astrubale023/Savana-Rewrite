package com.astrubale.savanarewrite.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.HorseEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EntityView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;
import com.astrubale.savanarewrite.item.ModItems;

public class Ostrich extends TameableEntity implements GeoEntity {
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    public Ostrich(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    /* ATTRIBUTES */
    public static DefaultAttributeContainer.Builder setAttribute() {
        return AnimalEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 2.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f);
    }

    /* GOALS */
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(3, new WanderAroundPointOfInterestGoal(this, 0.75, false));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 0.75, 0.5f));
        this.goalSelector.add(5, new LookAroundGoal(this));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));

        this.goalSelector.add(1, new AnimalMateGoal(this,1.0));
    }

    /* ANIMATIONS */
    private <E extends GeoEntity> PlayState predicate(AnimationState<E> event) {

        event.getController().setAnimation(RawAnimation.begin().thenLoop("ostrich.animation.idle"));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    /* SOUNDS */
    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {return SoundEvents.ENTITY_PARROT_AMBIENT;}
    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {return SoundEvents.ENTITY_DOLPHIN_HURT;}
    @Nullable
    @Override
    protected SoundEvent getDeathSound() {return SoundEvents.ENTITY_PARROT_DEATH;}
    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_CAMEL_STEP, 0.15f, 1.0f);
    }

    @Override
    public void onDeath(DamageSource damageSource) {
        super.onDeath(damageSource);

        if (!this.getWorld().isClient() && damageSource.getAttacker() instanceof PlayerEntity) {
            if(this.random.nextFloat() < 0.2) {
                this.dropItem(ModItems.GREAT_FEATHER, this.random.nextInt(2) + 1); // Drop da 1 a 2 piume
            }
        }
    }

    @Nullable
    @Override
    public ItemEntity dropItem(ItemConvertible item) {
        return super.dropItem(item);
    }

    /* GECKOLIB THINGS */
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.geoCache;
    }

    @Override
    public EntityView method_48926() {
        return this.getWorld();
    }
}
