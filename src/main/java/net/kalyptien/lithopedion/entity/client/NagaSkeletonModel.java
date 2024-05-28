package net.kalyptien.lithopedion.entity.client;


import net.kalyptien.lithopedion.LithopedionMod;
import net.kalyptien.lithopedion.entity.custom.NagaSkeletonEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class NagaSkeletonModel extends GeoModel<NagaSkeletonEntity> {

	@Override
	public ResourceLocation getModelResource(NagaSkeletonEntity animatable) {
		return new ResourceLocation(LithopedionMod.MODID, "geo/nagaskeleton.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(NagaSkeletonEntity animatable) {
		return new ResourceLocation(LithopedionMod.MODID, "textures/entity/nagaskeleton.png");
	}

	@Override
	public ResourceLocation getAnimationResource(NagaSkeletonEntity animatable) {
		return new ResourceLocation(LithopedionMod.MODID, "animations/nagaskeleton.json");
	}

	@Override
	public void setCustomAnimations(NagaSkeletonEntity animatable, long instanceId, AnimationState<NagaSkeletonEntity> animationState) {
		/*CoreGeoBone head = getAnimationProcessor().getBone("Skull");

		if (head != null) {
			EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}*/
	}
}