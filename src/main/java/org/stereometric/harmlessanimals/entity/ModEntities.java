package org.stereometric.harmlessanimals.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import org.stereometric.harmlessanimals.HarmlessAnimals;
import org.stereometric.harmlessanimals.entity.custom.GreenFishEntity;
import org.stereometric.harmlessanimals.entity.custom.MolluskEntity;
import org.stereometric.harmlessanimals.entity.custom.shrimp.CoralShrimpEntity;
import org.stereometric.harmlessanimals.entity.custom.shrimp.OrangeShrimpEntity;


public class ModEntities {
    public static final EntityType<CoralShrimpEntity> CORAL_SHRIMP = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(HarmlessAnimals.MOD_ID, "coral_shrimp"),
            FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, CoralShrimpEntity::new)
                    .dimensions(EntityDimensions.fixed(0.3F, 0.3F))
                    .trackRangeBlocks(64)
                    .build(RegistryKey.of(Registries.ENTITY_TYPE.getKey(), Identifier.of(HarmlessAnimals.MOD_ID, "shrimp")))
    );

    public static final EntityType<OrangeShrimpEntity> ORANGE_SHRIMP = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(HarmlessAnimals.MOD_ID, "orange_shrimp"),
            FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, OrangeShrimpEntity::new)
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

    public static final EntityType<GreenFishEntity> GREEN_FISH = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(HarmlessAnimals.MOD_ID, "green_fish"),
            FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, GreenFishEntity::new)
                    .dimensions(EntityDimensions.fixed(0.45F, 0.45F))
                    .trackRangeBlocks(64)
                    .build(RegistryKey.of(Registries.ENTITY_TYPE.getKey(), Identifier.of(HarmlessAnimals.MOD_ID, "fish")))
    );

    public static void registerEntities() {
        HarmlessAnimals.LOGGER.info("Registering Entities for " + HarmlessAnimals.MOD_ID);
    }
}