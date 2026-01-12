package org.stereometric.harmlessanimals.client.entity;

import net.minecraft.util.Identifier;
import org.stereometric.harmlessanimals.HarmlessAnimals;
import org.stereometric.harmlessanimals.entity.custom.GreenFishEntity;
import org.stereometric.harmlessanimals.entity.custom.MolluskEntity;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public class GreenFishModel extends GeoModel<GreenFishEntity> {

    @Override
    public Identifier getModelResource(GeoRenderState renderState) {
        return Identifier.of(HarmlessAnimals.MOD_ID, "fish");
    }

    @Override
    public Identifier getTextureResource(GeoRenderState renderState) {
        return Identifier.of(HarmlessAnimals.MOD_ID, "textures/entity/fish.png");
    }

    @Override
    public Identifier getAnimationResource(GreenFishEntity animatable) {
        return Identifier.of(HarmlessAnimals.MOD_ID, "fish");
    }
}
