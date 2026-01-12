package org.stereometric.harmlessanimals.client.entity;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import org.stereometric.harmlessanimals.entity.custom.GreenFishEntity;
import org.stereometric.harmlessanimals.entity.custom.MolluskEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public class GreenFishRenderer<R extends LivingEntityRenderState & GeoRenderState> extends GeoEntityRenderer<GreenFishEntity, R> {
    public GreenFishRenderer(EntityRendererFactory.Context context) {
        super(context, new GreenFishModel());
    }
}
