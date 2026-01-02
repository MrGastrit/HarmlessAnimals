package org.stereometric.harmlessanimals.client.entity;

import net.minecraft.util.Identifier;
import org.stereometric.harmlessanimals.HarmlessAnimals;
import org.stereometric.harmlessanimals.entity.custom.ShrimpEntity;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public class ShrimpModel extends GeoModel<ShrimpEntity> {

    private static final Identifier[] TEXTURES = {
            Identifier.of(HarmlessAnimals.MOD_ID, "textures/entity/coral_shrimp.png"),
            Identifier.of(HarmlessAnimals.MOD_ID, "textures/entity/orange_shrimp.png"),
    };

    @Override
    public Identifier getModelResource(GeoRenderState geoRenderState) {
        return Identifier.of(HarmlessAnimals.MOD_ID, "shrimp");
    }

    @Override
    public Identifier getTextureResource(GeoRenderState state) {
        return Identifier.of(HarmlessAnimals.MOD_ID, "textures/entity/orange_shrimp.png");
    }

    @Override
    public Identifier getAnimationResource(ShrimpEntity shrimpEntity) {
        return Identifier.of(HarmlessAnimals.MOD_ID, "shrimp");
    }
}
