package com.astrubale.savanarewrite.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class TaiwanLionBoss extends HostileEntity implements GeoEntity {

    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    private enum BossPhase {
        PHASE_ONE,
        PHASE_TWO,
        FINAL_FORM
    }

    private final ServerBossBar bossBar = new ServerBossBar(
            Text.literal("Leone Spadaccino"),
            BossBar.Color.YELLOW,
            BossBar.Style.PROGRESS
    );

    private BossPhase currentPhase = BossPhase.PHASE_ONE;
    private int specialAttackCooldown = 0;

    public TaiwanLionBoss(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 50;
    }

    public static DefaultAttributeContainer.Builder setAttribute() {
        return AnimalEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 80)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 2.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f);
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.getWorld().isClient()) {
            this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
        }

        if (!this.getWorld().isClient()) {
            updatePhase();
            handleCooldowns();
            handleSpecialAttacks();
        }
    }

    private void updatePhase() {
        float health = this.getHealth();
        float maxHealth = this.getMaxHealth();

        if (currentPhase == BossPhase.PHASE_ONE && health < maxHealth * 0.66F) {
            enterPhaseTwo();
        } else if (currentPhase == BossPhase.PHASE_TWO && health < maxHealth * 0.33F) {
            enterFinalPhase();
        }
    }

    private void handleCooldowns() {
        if (specialAttackCooldown > 0) {
            specialAttackCooldown--;
        }

        // Se aggiungi altri cooldown, mettili qui
        // es: jumpCooldown--, spawnCooldown--, ecc.
    }

    private void handleSpecialAttacks() {
        if (this.getTarget() == null || specialAttackCooldown > 0) {
            return;
        }

        switch (currentPhase) {
            case PHASE_ONE -> {
                // Placeholder attacco base
                // es: performDashBite();
            }
            case PHASE_TWO -> {
                // Placeholder attacco intermedio
                // es: performSwordThrow();
            }
            case FINAL_FORM -> {
                // Attacchi avanzati, più di uno magari
                // es: performMegaJump();
                // es: summonMinions();
            }
        }

        specialAttackCooldown = 100; // ⏱️ Imposta cooldown tra attacchi speciali
    }

    private void enterPhaseTwo() {
        currentPhase = BossPhase.PHASE_TWO;

        // Buff, effetti, suoni
        this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).setBaseValue(10.0);
        this.getWorld().playSound(null, this.getBlockPos(), SoundEvents.ENTITY_WITHER_HURT, SoundCategory.HOSTILE, 1.5F, 1.0F);

        // TODO: aggiungi particelle o animazioni se vuoi
    }

    private void enterFinalPhase() {
        currentPhase = BossPhase.FINAL_FORM;

        // this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(0.35);
        this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(300.0);
        this.setHealth(300.0F);

        this.getWorld().playSound(null, this.getBlockPos(), SoundEvents.ENTITY_WITHER_SPAWN, SoundCategory.HOSTILE, 2.0F, 0.8F);

        // TODO: aggiungi attacchi, aura, trasformazioni
    }

    @Override
    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        bossBar.addPlayer(player);
    }

    @Override
    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        bossBar.removePlayer(player);
    }

    public ServerBossBar getBossBar() {
        return bossBar;
    }

    /* ANIMATIONS */
    private <E extends GeoEntity> PlayState predicate(AnimationState<E> event) {

        event.getController().setAnimation(RawAnimation.begin().thenLoop("taiwan_lion.animation.idle"));
        return PlayState.CONTINUE;
    }

    /* GECKOLIB */
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.geoCache;
    }
}
