package org.stereometric.harmlessanimals.client.entity;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import org.stereometric.harmlessanimals.entity.custom.MolluskEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public class MolluskRenderer<R extends LivingEntityRenderState & GeoRenderState> extends GeoEntityRenderer<MolluskEntity, R> {
    public MolluskRenderer(EntityRendererFactory.Context context) {
        super(context, new MolluskModel());
    }
}
