package org.stereometric.harmlessanimals.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.SalmonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.manager.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public class ShrimpEntity extends FishEntity implements GeoEntity {
    public static final RawAnimation IDLE = RawAnimation.begin().thenLoop("idle");
    public static final RawAnimation WALK = RawAnimation.begin().thenLoop("walk");

    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    public ShrimpEntity(EntityType<? extends FishEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void writeCustomData(WriteView view) {
        super.writeCustomData(view);
    }

    @Override
    protected void readCustomData(ReadView view) {
        super.readCustomData(view);
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(2, new SwimAroundGoal(this, 0.1, 100));
        this.goalSelector.add(4, new LookAroundGoal(this));
    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.ENTITY_PUFFER_FISH_FLOP;
    }

    @Override
    protected ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (player.getStackInHand(hand).getItem() == Items.WATER_BUCKET) {
            return ActionResult.FAIL;
        }

        return super.interactMob(player, hand);
    }

    public static DefaultAttributeContainer.Builder createShrimpAttributes() {
        return AnimalEntity.createMobAttributes()
                .add(EntityAttributes.MOVEMENT_SPEED, 1.5D)
                .add(EntityAttributes.MAX_HEALTH, 2.0D)
                .add(EntityAttributes.KNOCKBACK_RESISTANCE, 0.2D);
    }

    public void tick() {
        super.tick();
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>("controller",
                5,
                state -> {
                    if (state.isMoving()) {
                        return state.setAndContinue(WALK);
                    }

                    return state.setAndContinue(IDLE);
                }
        ));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return geoCache;
    }

    @Override
    public ItemStack getBucketItem() {
        return null;
    }
}
