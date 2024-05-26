package net.kalyptien.lithopedion.entity.client;

import net.kalyptien.lithopedion.LithopedionMod;
import net.kalyptien.lithopedion.entity.custom.NagaSkeletonEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class NagaSkeletonRenderer extends MobRenderer<NagaSkeletonEntity, NagaSkeletonModel<NagaSkeletonEntity>> {

    public NagaSkeletonRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new NagaSkeletonModel<>(pContext.bakeLayer(ModModelLayers.NAGASKELETON_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(NagaSkeletonEntity pEntity) {
        return new ResourceLocation(LithopedionMod.MODID, "textures/entity/nagaskeleton.png");
    }

}
