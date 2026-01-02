package org.stereometric.harmlessanimals.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityType;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.particle.ShriekParticleEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import org.stereometric.harmlessanimals.HarmlessAnimals;
import org.stereometric.harmlessanimals.entity.custom.MolluskEntity;
import org.stereometric.harmlessanimals.entity.custom.ShrimpEntity;


public class ModEntities {
    public static final EntityType<ShrimpEntity> SHRIMP = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(HarmlessAnimals.MOD_ID, "shrimp"),
            FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, ShrimpEntity::new)
                    .dimensions(EntityDimensions.fixed(0.3F, 0.3F))
                    .trackRangeBlocks(64)
                    .build(RegistryKey.of(Registries.ENTITY_TYPE.getKey(), Identifier.of(HarmlessAnimals.MOD_ID, "shrimp")))
    );

    public static final EntityType<MolluskEntity> MOLLUSK = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(HarmlessAnimals.MOD_ID, "mollusk"),
            FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, MolluskEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6F, 0.35F))
                    .trackRangeBlocks(64)
                    .build(RegistryKey.of(Registries.ENTITY_TYPE.getKey(), Identifier.of(HarmlessAnimals.MOD_ID, "mollusk")))
    );

    public static void registerEntities() {
        HarmlessAnimals.LOGGER.info("Registering Entities for " + HarmlessAnimals.MOD_ID);
    }
}