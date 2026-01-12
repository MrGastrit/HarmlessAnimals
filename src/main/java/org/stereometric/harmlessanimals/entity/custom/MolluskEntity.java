package org.stereometric.harmlessanimals.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jspecify.annotations.Nullable;
import org.stereometric.harmlessanimals.item.ModItems;
import org.stereometric.harmlessanimals.particle.ModParticles;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.manager.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.animation.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class MolluskEntity extends AnimalEntity implements GeoEntity {
    public static final RawAnimation CLOSED_IDLE = RawAnimation.begin().thenLoop("closed_idle");
    public static final RawAnimation OPENED_IDLE = RawAnimation.begin().thenLoop("opened_idle");
    public static final RawAnimation OPENED_IDLE_NONE = RawAnimation.begin().thenLoop("opened_idle_none");
    public static final RawAnimation CLOSING = RawAnimation.begin().thenPlay("closing");
    public static final RawAnimation CLOSING_NONE = RawAnimation.begin().thenPlay("closing_none");

    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    private static final TrackedData<Boolean> HAS_PEARL =
            DataTracker.registerData(MolluskEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    private static final TrackedData<Boolean> IS_OPEN =
            DataTracker.registerData(MolluskEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    private static final TrackedData<Boolean> USED_THIS_NIGHT =
            DataTracker.registerData(MolluskEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    private static final TrackedData<Boolean> WAS_NIGHT_LAST_TICK =
            DataTracker.registerData(MolluskEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    private boolean wasOpenLastTick = false;
    private boolean closingWithPearl = false;

    public MolluskEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createMolluskAttributes() {
        return AnimalEntity.createMobAttributes()
                .add(EntityAttributes.MOVEMENT_SPEED, 0.0D)
                .add(EntityAttributes.MAX_HEALTH, 20.0D)
                .add(EntityAttributes.KNOCKBACK_RESISTANCE, 100.0D);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getEntityWorld().isClient()) {
            return;
        }

        World world = this.getEntityWorld();

        long time = world.getTimeOfDay();
        boolean isNight = time >= 13000 && time <= 23000;

        boolean wasNight = wasNightLastTick();

        if (!wasNight && isNight) {
            if (!usedThisNight()) {
                setOpen(true);
            }
        }

        if (wasNight && !isNight) {
            setOpen(false);
            setUsedThisNight(false);
            setHasPearl(random.nextBoolean());
        }

        setWasNightLastTick(isNight);
    }

    public boolean hasPearl() {
        return this.dataTracker.get(HAS_PEARL);
    }

    public boolean wasNightLastTick() {
        return this.dataTracker.get(WAS_NIGHT_LAST_TICK);
    }

    public void setWasNightLastTick(boolean value) {
        this.dataTracker.set(WAS_NIGHT_LAST_TICK, value);
    }

    public void setHasPearl(boolean value) {
        this.dataTracker.set(HAS_PEARL, value);
    }

    public boolean isOpen() {
        return this.dataTracker.get(IS_OPEN);
    }

    public void setOpen(boolean value) {
        boolean wasOpen = this.isOpen();

        this.dataTracker.set(IS_OPEN, value);

        if (wasOpen && !value) {
            this.closingWithPearl = hasPearl();
        }
    }

    public boolean usedThisNight() {
        return this.dataTracker.get(USED_THIS_NIGHT);
    }

    public void setUsedThisNight(boolean value) {
        this.dataTracker.set(USED_THIS_NIGHT, value);
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (!this.getEntityWorld().isClient() && this.isOpen() && !this.usedThisNight()) {
            boolean droppedPearl = false;
            if (player.getStackInHand(hand).isOf(Items.STICK)) {
                if (this.hasPearl() && this.random.nextBoolean()) {
                    setHasPearl(false);
                    player.giveItemStack(new ItemStack(ModItems.PEARL));
                    droppedPearl = true;
                }
                player.getStackInHand(hand).decrement(1);
                player.getEntityWorld().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.PLAYERS, 1.0F, 1.0F);

                ServerWorld world = (ServerWorld) player.getEntityWorld();
                world.spawnParticles(ModParticles.PAIN_PARTICLE, this.getX(), this.getY(), this.getZ(), 10, 0.2, 0.2, 0.2, 0.1);

                setUsedThisNight(true);
                setOpen(false);
                this.closingWithPearl = droppedPearl;

                return ActionResult.SUCCESS;
            } else {
                player.damage((ServerWorld) player.getEntityWorld(), player.getDamageSources().mobAttack(this), 4);
                setUsedThisNight(true);
                setOpen(false);

                this.closingWithPearl = droppedPearl;

                return ActionResult.SUCCESS;
            }
        }


        return super.interactMob(player, hand);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return false;
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(HAS_PEARL, random.nextBoolean());
        builder.add(IS_OPEN, false);
        builder.add(USED_THIS_NIGHT, false);
        builder.add(WAS_NIGHT_LAST_TICK, false);
    }

    @Override
    protected void writeCustomData(WriteView view) {
        super.writeCustomData(view);
        view.putBoolean("HasPearl", hasPearl());
        view.putBoolean("IsOpen", isOpen());
        view.putBoolean("UsedThisNight", usedThisNight());
        view.putBoolean("WasNightLastTick", wasNightLastTick());
    }

    @Override
    protected void readCustomData(ReadView view) {
        super.readCustomData(view);
        if (view.contains("HasPearl")) setHasPearl(view.getBoolean("HasPearl", false));
        if (view.contains("IsOpen")) setOpen(view.getBoolean("IsOpen", false));
        if (view.contains("UsedThisNight")) setUsedThisNight(view.getBoolean("UsedThisNight", false));
        if (view.contains("WasNightLastTick")) setWasNightLastTick(view.getBoolean("WasNightLastTick", false));
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>("main", 5, state -> {

            boolean open = this.isOpen();
            boolean pearl = this.hasPearl();

            if (wasOpenLastTick != open) {
                wasOpenLastTick = open;

                if (open) {
                    return state.setAndContinue(pearl ? OPENED_IDLE : OPENED_IDLE_NONE);
                } else {
                    state.setAnimation(closingWithPearl ? CLOSING : CLOSING_NONE);
                    return PlayState.CONTINUE;
                }
            }

            if (state.isCurrentAnimation(CLOSING) || state.isCurrentAnimation(CLOSING_NONE)) {
                return PlayState.CONTINUE;
            }

            if (!open) {
                return state.setAndContinue(CLOSED_IDLE);
            }

            return state.setAndContinue(pearl ? OPENED_IDLE : OPENED_IDLE_NONE);
        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return geoCache;
    }


    //shit
    public static boolean canSpawnOnOceanFloor(
            EntityType<MolluskEntity> type,
            ServerWorldAccess world,
            SpawnReason reason,
            BlockPos pos,
            Random random
    ) {

        if (!world.getFluidState(pos).isIn(FluidTags.WATER)) {
            return false;
        }

        BlockState below = world.getBlockState(pos.down());
        if (!below.isSolidBlock(world, pos.down())) {
            return false;
        }

        if (pos.getY() > world.getSeaLevel() - 5) {
            return false;
        }

        return true;
    }

}

