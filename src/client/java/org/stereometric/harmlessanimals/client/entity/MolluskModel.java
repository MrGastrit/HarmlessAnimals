package org.stereometric.harmlessanimals.client.entity;

import net.minecraft.util.Identifier;
import org.stereometric.harmlessanimals.HarmlessAnimals;
import org.stereometric.harmlessanimals.entity.custom.MolluskEntity;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public class MolluskModel extends GeoModel<MolluskEntity> {


    @Override
    public Identifier getModelResource(GeoRenderState renderState) {
        return Identifier.of(HarmlessAnimals.MOD_ID, "mollusk");
    }

    @Override
    public Identifier getTextureResource(GeoRenderState renderState) {
        return Identifier.of(HarmlessAnimals.MOD_ID, "textures/entity/mollusk.png");
    }

    @Override
    public Identifier getAnimationResource(MolluskEntity animatable) {
        return Identifier.of(HarmlessAnimals.MOD_ID, "mollusk");
    }
}
