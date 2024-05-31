package net.kalyptien.lithopedion.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.util.GeckoLibUtil;

public class OniSkeletonEntity extends UndeadEntity implements GeoEntity {

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public OniSkeletonEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public String getTextureName(){
        return "oniskeleton";
    }
    public static AttributeSupplier createAttribute(){
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 30D)
                .add(Attributes.FOLLOW_RANGE, 15.0f)
                .add(Attributes.ATTACK_KNOCKBACK, 2)
                .add(Attributes.MOVEMENT_SPEED, 0.3f)
                .add(Attributes.ATTACK_SPEED, 2f)
                .add(Attributes.ATTACK_DAMAGE, 6.0f).build();
    }

}
