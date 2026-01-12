package org.stereometric.harmlessanimals.entity.custom.shrimp;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.world.World;
import org.stereometric.harmlessanimals.entity.custom.ShrimpEntity;

public class CoralShrimpEntity extends ShrimpEntity {
    public CoralShrimpEntity(EntityType<? extends FishEntity> entityType, World world) {
        super(entityType, world);
    }
}
