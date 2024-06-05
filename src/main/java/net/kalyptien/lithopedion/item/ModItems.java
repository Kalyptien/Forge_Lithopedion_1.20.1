package net.kalyptien.lithopedion.item;

import net.kalyptien.lithopedion.entity.ModEntities;
import net.kalyptien.lithopedion.LithopedionMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LithopedionMod.MODID);

    public static final RegistryObject<Item> JADE = ITEMS.register("jade", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NAGA_HEART = ITEMS.register("naga_heart",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ONI_HEART = ITEMS.register("oni_heart",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MERMAID_HEART = ITEMS.register("mermaid_heart",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TENGU_HEART = ITEMS.register("tengu_heart",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOBLIN_HEART = ITEMS.register("goblin_heart",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NAGASKELETON_SPANW_EGG = ITEMS.register("nagaskeleton_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.NAGASKELETON, 0x9FB4B6, 0xce7e00, new Item.Properties()));
    public static final RegistryObject<Item> ONISKELETON_SPANW_EGG = ITEMS.register("oniskeleton_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.ONISKELETON, 0x9FB4B6, 0xf44336, new Item.Properties()));
    public static final RegistryObject<Item> TENGUSKELETON_SPANW_EGG = ITEMS.register("tenguskeleton_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.TENGUSKELETON, 0x9FB4B6, 0x16537e, new Item.Properties()));
    public static final RegistryObject<Item> GOBLINSKELETON_SPANW_EGG = ITEMS.register("goblinskeleton_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.GOBLINSKELETON, 0x9FB4B6, 0x8fce00, new Item.Properties()));
    public static final RegistryObject<Item> MERMAIDSKELETON_SPANW_EGG = ITEMS.register("mermaidskeleton_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.MERMAIDSKELETON, 0x9FB4B6, 0x16537e, new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
