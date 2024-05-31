package net.kalyptien.lithopedion.entity;

import net.kalyptien.lithopedion.LithopedionMod;
import net.kalyptien.lithopedion.entity.custom.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, LithopedionMod.MODID);

    public static final Supplier<EntityType<NagaSkeletonEntity>> NAGASKELETON = ENTITY_TYPES.register("nagaskeleton", () -> EntityType.Builder.of(NagaSkeletonEntity::new, MobCategory.MONSTER)
            .sized(1f, 2f).build("nagaskeleton"));

    public static final Supplier<EntityType<OniSkeletonEntity>> ONISKELETON = ENTITY_TYPES.register("oniskeleton", () -> EntityType.Builder.of(OniSkeletonEntity::new, MobCategory.MONSTER)
            .sized(1f, 2f).build("oniskeleton"));

    public static final Supplier<EntityType<GoblinSkeletonEntity>> GOBLINSKELETON = ENTITY_TYPES.register("goblinskeleton", () -> EntityType.Builder.of(GoblinSkeletonEntity::new, MobCategory.MONSTER)
            .sized(1f, 2f).build("goblinskeleton"));

    public static final Supplier<EntityType<MermaidSkeletonEntity>> MERMAIDSKELETON = ENTITY_TYPES.register("mermaidskeleton", () -> EntityType.Builder.of(MermaidSkeletonEntity::new, MobCategory.MONSTER)
            .sized(1f, 2f).build("mermaidskeleton"));

    public static final Supplier<EntityType<TenguSkeletonEntity>> TENGUSKELETON = ENTITY_TYPES.register("tenguskeleton", () -> EntityType.Builder.of(TenguSkeletonEntity::new, MobCategory.MONSTER)
            .sized(1f, 2f).build("tenguskeleton"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
