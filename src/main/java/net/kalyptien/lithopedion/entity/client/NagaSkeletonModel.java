package net.kalyptien.lithopedion.entity.client;// Made with Blockbench 4.10.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.kalyptien.lithopedion.entity.animations.ModAnimationDefinition;
import net.kalyptien.lithopedion.entity.custom.NagaSkeletonEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class NagaSkeletonModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "naga_skeleton"), "main");
	private final ModelPart NagaSkeleton;
	private final ModelPart Head;

	public NagaSkeletonModel(ModelPart root) {
		this.NagaSkeleton = root.getChild("NagaSkeleton");
		this.Head = NagaSkeleton.getChild("Skull");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition NagaSkeleton = partdefinition.addOrReplaceChild("NagaSkeleton", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition ArmL = NagaSkeleton.addOrReplaceChild("ArmL", CubeListBuilder.create(), PartPose.offset(3.7F, -18.8379F, 2.0186F));

		PartDefinition FrontArm2 = ArmL.addOrReplaceChild("FrontArm2", CubeListBuilder.create().texOffs(18, 19).addBox(-1.0F, -3.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.3186F, 0.3038F));

		PartDefinition BackArm2 = ArmL.addOrReplaceChild("BackArm2", CubeListBuilder.create().texOffs(24, 9).addBox(6.3F, -0.0201F, -1.1797F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.3F, -7.1621F, 0.1814F));

		PartDefinition ArmR = NagaSkeleton.addOrReplaceChild("ArmR", CubeListBuilder.create(), PartPose.offset(-3.6F, -19.0F, 2.2F));

		PartDefinition BackArm = ArmR.addOrReplaceChild("BackArm", CubeListBuilder.create().texOffs(0, 27).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

		PartDefinition FrontArm = ArmR.addOrReplaceChild("FrontArm", CubeListBuilder.create().texOffs(26, 19).addBox(-1.0F, -3.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.4997F, -0.0765F));

		PartDefinition Tail = NagaSkeleton.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Frag1 = Tail.addOrReplaceChild("Frag1", CubeListBuilder.create(), PartPose.offset(0.0F, -17.4183F, 2.6187F));

		PartDefinition cube_r1 = Frag1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(8, 32).addBox(-1.5F, 0.5F, -1.25F, 3.0F, 3.0F, 2.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -1.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition cube_r2 = Frag1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(34, 22).addBox(-1.5F, -3.5F, -1.25F, 3.0F, 3.0F, 2.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.5F, -1.25F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Frag2 = Tail.addOrReplaceChild("Frag2", CubeListBuilder.create(), PartPose.offset(0.0F, -12.5894F, 0.2685F));

		PartDefinition cube_r3 = Frag2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(33, 7).addBox(-1.4F, 0.5F, -1.25F, 2.8F, 3.0F, 2.5F, new CubeDeformation(0.0F))
		.texOffs(35, 17).addBox(-1.4F, -3.5F, -1.25F, 2.8F, 3.0F, 2.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -2.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition Frag3 = Tail.addOrReplaceChild("Frag3", CubeListBuilder.create(), PartPose.offset(0.0F, -8.7126F, -4.0048F));

		PartDefinition cube_r4 = Frag3.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 36).addBox(-1.5F, -3.15F, -1.25F, 3.0F, 2.3F, 2.5F, new CubeDeformation(0.0F))
		.texOffs(34, 0).addBox(-1.5F, -0.15F, -1.25F, 3.0F, 3.3F, 2.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition Frag4 = Tail.addOrReplaceChild("Frag4", CubeListBuilder.create(), PartPose.offset(0.0F, -3.3777F, -4.4403F));

		PartDefinition cube_r5 = Frag4.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(29, 33).addBox(-1.4F, 0.5F, -1.25F, 2.8F, 3.0F, 2.5F, new CubeDeformation(0.0F))
		.texOffs(29, 28).addBox(-1.4F, -3.5F, -1.25F, 2.8F, 3.0F, 2.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 3.0F, 1.2217F, 0.0F, 0.0F));

		PartDefinition Frag5 = Tail.addOrReplaceChild("Frag5", CubeListBuilder.create(), PartPose.offset(0.0F, -1.2626F, 1.9452F));

		PartDefinition cube_r6 = Frag5.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(18, 28).addBox(-1.5F, 0.5F, -1.25F, 3.0F, 3.0F, 2.5F, new CubeDeformation(0.0F))
		.texOffs(18, 33).addBox(-1.5F, -3.5F, -1.25F, 3.0F, 3.0F, 2.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition Frag6 = Tail.addOrReplaceChild("Frag6", CubeListBuilder.create(), PartPose.offset(0.0F, -1.5126F, 8.9452F));

		PartDefinition cube_r7 = Frag6.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(8, 27).addBox(-1.5F, 0.5F, -1.5F, 3.0F, 3.0F, 2.5F, new CubeDeformation(0.0F))
		.texOffs(32, 12).addBox(-1.5F, -3.5F, -1.5F, 3.0F, 3.0F, 2.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition Frag7 = Tail.addOrReplaceChild("Frag7", CubeListBuilder.create(), PartPose.offset(0.0F, -1.5126F, 15.9452F));

		PartDefinition cube_r8 = Frag7.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(10, 19).addBox(-1.25F, -3.5F, -1.5F, 2.5F, 3.0F, 2.25F, new CubeDeformation(0.0F))
		.texOffs(10, 37).addBox(-1.25F, 0.5F, -1.5F, 2.5F, 3.0F, 2.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition Frag8 = Tail.addOrReplaceChild("Frag8", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0126F, 22.9452F));

		PartDefinition cube_r9 = Frag8.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 18).addBox(-1.0F, -3.5F, -1.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(36, 36).addBox(-1.0F, 0.5F, -1.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 3.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition Chest = NagaSkeleton.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -7.25F, -2.0F, 5.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -18.75F, 2.0F));

		PartDefinition Neck = NagaSkeleton.addOrReplaceChild("Neck", CubeListBuilder.create(), PartPose.offset(0.0F, -27.4708F, -1.0947F));

		PartDefinition Frag9 = Neck.addOrReplaceChild("Frag9", CubeListBuilder.create().texOffs(36, 31).addBox(-1.5F, -1.25F, -1.9F, 3.0F, 2.5F, 2.05F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-1.5F, -1.25F, -4.15F, 3.0F, 2.5F, 1.8F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.7792F, 0.2447F));

		PartDefinition Frag10 = Neck.addOrReplaceChild("Frag10", CubeListBuilder.create(), PartPose.offset(0.0F, 1.7792F, 3.7553F));

		PartDefinition cube_r10 = Frag10.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(18, 38).addBox(-1.25F, -1.25F, -2.5F, 2.5F, 2.5F, 2.25F, new CubeDeformation(0.0F))
		.texOffs(26, 38).addBox(-1.25F, -1.25F, 0.25F, 2.5F, 2.5F, 2.25F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -2.0F, -0.6981F, 0.0F, 0.0F));

		PartDefinition Skull = NagaSkeleton.addOrReplaceChild("Skull", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -5.0F));

		PartDefinition Head = Skull.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(18, 0).addBox(-2.5F, -3.125F, -2.0F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(18, 5).addBox(-2.5F, -2.125F, -8.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 40).addBox(2.5F, -2.125F, -4.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(38, 27).addBox(-2.5F, -2.125F, -4.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 12).addBox(-2.5F, -3.125F, -7.0F, 6.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -26.875F, 0.0F));

		PartDefinition Jawbone = Skull.addOrReplaceChild("Jawbone", CubeListBuilder.create().texOffs(0, 18).addBox(-2.9F, -0.125F, -8.75F, 1.55F, 1.25F, 8.75F, new CubeDeformation(0.0F))
		.texOffs(0, 2).addBox(-2.9F, -1.625F, -8.75F, 1.55F, 1.5F, 1.5F, new CubeDeformation(0.0F))
		.texOffs(14, 10).addBox(2.35F, -0.125F, -8.75F, 1.55F, 1.25F, 8.75F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(2.35F, -1.625F, -8.75F, 1.55F, 1.5F, 1.5F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -26.875F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationDefinition.NagaSkeletonAnimation.NAGASKELETON_WALK, limbSwing, limbSwingAmount, 5f, 16f);
		this.animate(((NagaSkeletonEntity) entity).idleAnimationState, ModAnimationDefinition.NagaSkeletonAnimation.NAGASKELETON_IDLE, ageInTicks, 1f);
		this.animate(((NagaSkeletonEntity) entity).attackAnimationState, ModAnimationDefinition.NagaSkeletonAnimation.NAGASKELETON_ATTACK, ageInTicks, 0.1f);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.Head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.Head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		NagaSkeleton.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return NagaSkeleton;
	}
}