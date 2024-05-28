package net.kalyptien.lithopedion.entity.custom;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class NagaSkeletonEntity extends Monster implements GeoEntity {

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public NagaSkeletonEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));

        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, true));

        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.1D));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    // Add a generic idle controller, with a 5-tick transition time
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

        /*controllers.add(new AnimationController<>(this,"idlewalk",5, state -> {
                if (state.isMoving()) {
                    state.getController().setAnimation(DefaultAnimations.WALK);
                } else {
                    state.getController().setAnimation(DefaultAnimations.IDLE);
                }
                return PlayState.CONTINUE;
        }));*/

        controllers.add(new AnimationController(this, "attack", 5, (state) -> {
            if (this.swinging) {
                return state.setAndContinue(DefaultAnimations.ATTACK_STRIKE);
            } else {
                state.getController().forceAnimationReset();
                return PlayState.STOP;
            }
        }));

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    public static AttributeSupplier createAttribute(){
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 15D)
                .add(Attributes.FOLLOW_RANGE, 12.0f)
                .add(Attributes.ATTACK_KNOCKBACK, 1)
                .add(Attributes.MOVEMENT_SPEED, 0.4f)
                .add(Attributes.ATTACK_SPEED, 1.2f)
                .add(Attributes.ATTACK_DAMAGE, 2.0f).build();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.SKELETON_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.SKELETON_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.SKELETON_DEATH;
    }

}
