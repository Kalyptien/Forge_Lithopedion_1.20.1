package net.kalyptien.lithopedion.datagen.loot;

import net.kalyptien.lithopedion.LithopedionMod;
import net.kalyptien.lithopedion.entity.ModEntities;
import net.kalyptien.lithopedion.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithLootingCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import static net.minecraft.commands.arguments.EntityArgument.getEntity;

public class ModEntityLootTables implements LootTableSubProvider {

    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> output) {

        output.accept(getEntity(ModEntities.NAGASKELETON.get()), getDefaultUndeadLootTable(ModItems.NAGA_HEART));
        output.accept(getEntity(ModEntities.ONISKELETON.get()), getDefaultUndeadLootTable(ModItems.ONI_HEART));
        output.accept(getEntity(ModEntities.MERMAIDSKELETON.get()), getDefaultUndeadLootTable(ModItems.MERMAID_HEART));
        output.accept(getEntity(ModEntities.TENGUSKELETON.get()), getDefaultUndeadLootTable(ModItems.TENGU_HEART));
        output.accept(getEntity(ModEntities.GOBLINSKELETON.get()), getDefaultUndeadLootTable(ModItems.GOBLIN_HEART));

    }

    private static LootTable.Builder getDefaultUndeadLootTable(Supplier<Item> additionalLoot) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(Items.BONE).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0f, 2.0f))).apply(LootingEnchantFunction
                                .lootingMultiplier(UniformGenerator.between(0.0f, 1.0f))))
                        .add(LootItem.lootTableItem(additionalLoot.get()).apply(SetItemCountFunction
                                .setCount(UniformGenerator.between(0.0f, 1.0f)))
                        .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.05f, 0.025f))));
    }

    private static ResourceLocation getEntity(EntityType<?> entity) {
        return new ResourceLocation(LithopedionMod.MODID, "entities/%s".formatted(Objects.requireNonNull(BuiltInRegistries.ENTITY_TYPE.getKey(entity)).getPath()));
    }
}
