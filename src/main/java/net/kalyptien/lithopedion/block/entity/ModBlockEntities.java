package net.kalyptien.lithopedion.block.entity;

import net.kalyptien.lithopedion.LithopedionMod;
import net.kalyptien.lithopedion.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, LithopedionMod.MODID);

    public static final RegistryObject<BlockEntityType<SculptureTableBlockEntity>> SCULPTURE_TABLE_BE =
            BLOCK_ENTITIES.register("sculpture_table_be", () ->
                    BlockEntityType.Builder.of(SculptureTableBlockEntity::new,
                            ModBlocks.SCULPTURE_TABLE.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}