package org.stereometric.harmlessanimals.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import org.stereometric.harmlessanimals.particle.ModParticles;

public class PainEffect extends StatusEffect {
    private int tick = 0;

    public PainEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        entity.setNoDrag(true);
        this.tick++;

        if (tick % 5 == 0) {
            world.spawnParticles(ModParticles.PAIN_PARTICLE, entity.getX(), entity.getY() + 1, entity.getZ(), 3, 0.01, 0.01, 0.01, 0.05);
        }

        if (this.tick == 98) {
            entity.setNoDrag(false);
            world.playSound(entity, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.ENCHANT_THORNS_HIT, SoundCategory.MASTER);
            entity.damage(world, entity.getDamageSources().cactus(), amplifier + 1);
            this.tick = 0;
        }

        return super.applyUpdateEffect(world, entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
