package org.stereometric.harmlessanimals.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.particle.EndRodParticle;
import org.stereometric.harmlessanimals.HarmlessAnimals;
import org.stereometric.harmlessanimals.client.entity.MolluskRenderer;
import org.stereometric.harmlessanimals.client.entity.ShrimpModel;
import org.stereometric.harmlessanimals.client.entity.ShrimpRenderer;
import org.stereometric.harmlessanimals.entity.ModEntities;
import org.stereometric.harmlessanimals.particle.ModParticles;

public class HarmlessAnimalsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.SHRIMP, ShrimpRenderer::new);
        EntityRendererRegistry.register(ModEntities.MOLLUSK, MolluskRenderer::new);

        ParticleFactoryRegistry.getInstance().register(ModParticles.PAIN_PARTICLE, EndRodParticle.Factory::new);
    }
}
