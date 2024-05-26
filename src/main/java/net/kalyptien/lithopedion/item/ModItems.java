package net.kalyptien.lithopedion.item;

import net.kalyptien.lithopedion.LithopedionMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LithopedionMod.MODID);

    public static final Supplier<Item> JADE = ITEMS.register("jade", () -> new Item(new Item.Properties()));

    public static final Supplier<Item> NAGA_HEART = ITEMS.register("naga_heart",
            () -> new Item(new Item.Properties()));
    public static final Supplier<Item> ONI_HEART = ITEMS.register("oni_heart",
            () -> new Item(new Item.Properties()));
    public static final Supplier<Item> MERMAID_HEART = ITEMS.register("mermaid_heart",
            () -> new Item(new Item.Properties()));
    public static final Supplier<Item> TENGU_HEART = ITEMS.register("tengu_heart",
            () -> new Item(new Item.Properties()));
    public static final Supplier<Item> GOBLIN_HEART = ITEMS.register("goblin_heart",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
