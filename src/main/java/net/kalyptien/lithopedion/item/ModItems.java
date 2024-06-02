package net.kalyptien.lithopedion.item;

import net.kalyptien.lithopedion.LithopedionMod;
import net.minecraft.world.item.Item;
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

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
