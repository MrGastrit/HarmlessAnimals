package org.stereometric.harmlessanimals.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.stereometric.harmlessanimals.HarmlessAnimals;

public class ModParticles {

    public static final SimpleParticleType PAIN_PARTICLE = FabricParticleTypes.simple(true);

    public static void registerParticles() {
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(HarmlessAnimals.MOD_ID, "pain_particle"), PAIN_PARTICLE);
    }
}
