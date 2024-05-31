package net.kalyptien.lithopedion.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.kalyptien.lithopedion.LithopedionMod;
import net.kalyptien.lithopedion.entity.custom.NagaSkeletonEntity;
import net.kalyptien.lithopedion.entity.custom.UndeadEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class UndeadRenderer extends GeoEntityRenderer<UndeadEntity> {

    public UndeadRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new UndeadModel());
    }

    @Override
    public ResourceLocation getTextureLocation(UndeadEntity animatable) {
        return new ResourceLocation(LithopedionMod.MODID, "textures/entity/" + animatable.getTextureName()  + ".png");
    }

    @Override
    public void render(UndeadEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

}
