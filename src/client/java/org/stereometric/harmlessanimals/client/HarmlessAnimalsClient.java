package org.stereometric.harmlessanimals.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.particle.EndRodParticle;
import org.stereometric.harmlessanimals.client.entity.GreenFishRenderer;
import org.stereometric.harmlessanimals.client.entity.MolluskRenderer;
import org.stereometric.harmlessanimals.client.entity.shrimp.CoralShrimpRenderer;
import org.stereometric.harmlessanimals.client.entity.shrimp.OrangeShrimpRenderer;
import org.stereometric.harmlessanimals.entity.ModEntities;
import org.stereometric.harmlessanimals.particle.ModParticles;

public class HarmlessAnimalsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.ORANGE_SHRIMP, OrangeShrimpRenderer::new);
        EntityRendererRegistry.register(ModEntities.CORAL_SHRIMP, CoralShrimpRenderer::new);
        EntityRendererRegistry.register(ModEntities.MOLLUSK, MolluskRenderer::new);
        EntityRendererRegistry.register(ModEntities.GREEN_FISH, GreenFishRenderer::new);

        ParticleFactoryRegistry.getInstance().register(ModParticles.PAIN_PARTICLE, EndRodParticle.Factory::new);
    }
}
