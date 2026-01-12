package org.stereometric.harmlessanimals.client.entity.shrimp;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import org.stereometric.harmlessanimals.entity.custom.shrimp.OrangeShrimpEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public class OrangeShrimpRenderer<R extends LivingEntityRenderState & GeoRenderState> extends GeoEntityRenderer<OrangeShrimpEntity, R> {
    public OrangeShrimpRenderer(EntityRendererFactory.Context context) {
        super(context, new OrangeShrimpModel());
    }
}