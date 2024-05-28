package net.kalyptien.lithopedion.entity;

import net.kalyptien.lithopedion.LithopedionMod;
import net.kalyptien.lithopedion.entity.custom.NagaSkeletonEntity;
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

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
