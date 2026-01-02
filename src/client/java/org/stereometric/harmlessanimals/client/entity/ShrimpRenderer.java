package org.stereometric.harmlessanimals.client.entity;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import org.stereometric.harmlessanimals.entity.custom.ShrimpEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public class ShrimpRenderer<R extends LivingEntityRenderState & GeoRenderState> extends GeoEntityRenderer<ShrimpEntity, R> {
    public ShrimpRenderer(EntityRendererFactory.Context context) {
        super(context, new ShrimpModel());
    }
}