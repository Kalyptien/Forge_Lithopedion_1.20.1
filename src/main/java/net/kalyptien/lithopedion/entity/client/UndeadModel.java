package net.kalyptien.lithopedion.entity.client;


import net.kalyptien.lithopedion.LithopedionMod;
import net.kalyptien.lithopedion.entity.custom.UndeadEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class UndeadModel extends GeoModel<UndeadEntity> {

	@Override
	public ResourceLocation getModelResource(UndeadEntity animatable) {
		return new ResourceLocation(LithopedionMod.MODID, "geo/" + animatable.getTextureName()  + ".geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(UndeadEntity animatable) {
		return new ResourceLocation(LithopedionMod.MODID, "textures/entity/" + animatable.getTextureName()  + ".png");
	}

	@Override
	public ResourceLocation getAnimationResource(UndeadEntity animatable) {
		return new ResourceLocation(LithopedionMod.MODID, "animations/" + animatable.getTextureName()  + ".json");
	}

	@Override
	public void setCustomAnimations(UndeadEntity animatable, long instanceId, AnimationState<UndeadEntity> animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("Skull");

		if (head != null) {
			EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}
	}
}