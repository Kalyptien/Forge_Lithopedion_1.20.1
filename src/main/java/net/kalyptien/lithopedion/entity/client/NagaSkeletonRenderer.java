package net.kalyptien.lithopedion.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.kalyptien.lithopedion.LithopedionMod;
import net.kalyptien.lithopedion.entity.custom.NagaSkeletonEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class NagaSkeletonRenderer extends GeoEntityRenderer<NagaSkeletonEntity> {

    public NagaSkeletonRenderer (EntityRendererProvider.Context renderManager) {
        super(renderManager, new NagaSkeletonModel());
    }

    @Override
    public ResourceLocation getTextureLocation(NagaSkeletonEntity animatable) {
        return new ResourceLocation(LithopedionMod.MODID, "textures/entity/nagaskeleton.png");
    }

    @Override
    public void render(NagaSkeletonEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

}
