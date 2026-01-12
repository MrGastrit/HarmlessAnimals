package org.stereometric.harmlessanimals.entity.custom.shrimp;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.SalmonEntity;
import net.minecraft.world.World;
import org.stereometric.harmlessanimals.entity.custom.ShrimpEntity;

public class OrangeShrimpEntity extends ShrimpEntity {

    public OrangeShrimpEntity(EntityType<? extends FishEntity> entityType, World world) {
        super(entityType, world);
    }
}
