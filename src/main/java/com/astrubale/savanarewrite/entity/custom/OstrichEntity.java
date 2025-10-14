package com.astrubale.savanarewrite.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
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

public class OstrichEntity extends AbstractHorseEntity {

    public OstrichEntity(EntityType<? extends AbstractHorseEntity> entityType, World world) {
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
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5f)
                .add(EntityAttributes.HORSE_JUMP_STRENGTH, 0.5f);
    }

    /* GOALS */
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 1.2D));
        this.goalSelector.add(2, new AnimalMateGoal(this, 1.0D));
        this.goalSelector.add(3, new TemptGoal(this, 1.0D, Ingredient.ofItems(Items.WHEAT_SEEDS), false));
        this.goalSelector.add(4, new FollowParentGoal(this, 1.0D));
        this.goalSelector.add(5, new WanderAroundGoal(this, 0.7D));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(7, new LookAroundGoal(this));
    }

    /* ANIMATIONS */

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
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        boolean bl = !this.isBaby() && this.isTame() && player.shouldCancelInteraction();
        if(this.hasPassengers() || bl) {
            return super.interactMob(player, hand);
        }

        ItemStack itemStack = player.getStackInHand(hand);
        if(!itemStack.isEmpty()) {
            if(this.isBreedingItem(itemStack)) {
                return interactHorse(player, itemStack);
            }

            if(!this.isTame()) {
                this.playAngrySound();
                return ActionResult.success(this.getWorld().isClient());
            }
        }

        return super.interactMob(player, hand);
    }

    @Override
    public void tickMovement() {
        super.tickMovement();

        if (this.isAlive() && this.hasPassengers() && this.getFirstPassenger() instanceof PlayerEntity player) {
            if (!this.isTame()) {
                if (this.getTemper() > 67 && this.random.nextInt(200)==0) {
                    this.setOwnerUuid(player.getUuid());
                    this.setTame(true);
                    this.getWorld().sendEntityStatus(this, (byte)7);
                }
                if (this.random.nextInt(400) == 0) {
                    player.stopRiding();
                    this.getWorld().sendEntityStatus(this, (byte)6);
                }
            }
        }
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

    @Override
    public EntityView method_48926() {
        return this.getWorld();
    }
}
