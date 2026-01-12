package org.stereometric.harmlessanimals;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.BuiltinRegistries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.stereometric.harmlessanimals.effect.ModEffects;
import org.stereometric.harmlessanimals.entity.ModEntities;
import org.stereometric.harmlessanimals.entity.custom.GreenFishEntity;
import org.stereometric.harmlessanimals.entity.custom.MolluskEntity;
import org.stereometric.harmlessanimals.entity.custom.ShrimpEntity;
import org.stereometric.harmlessanimals.item.ModItems;
import org.stereometric.harmlessanimals.item.ModItemsGroups;
import org.stereometric.harmlessanimals.particle.ModParticles;
import org.stereometric.harmlessanimals.world.gen.ModWorldGeneration;

public class HarmlessAnimals implements ModInitializer {

    public static final String MOD_ID = "harmlessanimals";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModEntities.registerEntities();
        ModEffects.registerEffects();
        ModItems.registerItems();
        ModItemsGroups.registerItemGroups();
        ModParticles.registerParticles();
        ModWorldGeneration.generateModWorldGen();

        FabricDefaultAttributeRegistry.register(ModEntities.ORANGE_SHRIMP, ShrimpEntity.createShrimpAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.CORAL_SHRIMP, ShrimpEntity.createShrimpAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.MOLLUSK, MolluskEntity.createMolluskAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.GREEN_FISH, GreenFishEntity.createGFishAttributes());
    }
}
