package net.kalyptien.lithopedion;

import net.kalyptien.lithopedion.item.ModItems;
import net.kalyptien.lithopedion.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.kalyptien.lithopedion.LithopedionMod.MODID;

public class ModCreativeModTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final Supplier<CreativeModeTab> CREATIVE_MODE_TAB = CREATIVE_MODE_TABS.register("example", () -> CreativeModeTab.builder()
            .title(Component.translatable("creativetab.lithopedion_tab"))
            .icon(() -> new ItemStack(ModItems.JADE.get()))
            .displayItems((params, output) -> {
                output.accept(ModItems.JADE.get());

                output.accept(ModItems.NAGA_HEART.get());
                output.accept(ModItems.ONI_HEART.get());
                output.accept(ModItems.MERMAID_HEART.get());
                output.accept(ModItems.TENGU_HEART.get());
                output.accept(ModItems.GOBLIN_HEART.get());

                output.accept(ModBlocks.JADE_BLOCK.get());
                output.accept(ModBlocks.DEEPSLATE_JADE_ORE.get());

                output.accept(ModItems.NAGASKELETON_SPANW_EGG.get());
                output.accept(ModItems.ONISKELETON_SPANW_EGG.get());
                output.accept(ModItems.MERMAIDSKELETON_SPANW_EGG.get());
                output.accept(ModItems.GOBLINSKELETON_SPANW_EGG.get());
                output.accept(ModItems.TENGUSKELETON_SPANW_EGG.get());

                output.accept(ModBlocks.SCULPTURE_TABLE.get());
            })
            .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
