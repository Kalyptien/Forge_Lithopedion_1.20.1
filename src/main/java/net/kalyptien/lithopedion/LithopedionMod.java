package net.kalyptien.lithopedion;

import com.mojang.logging.LogUtils;
import net.kalyptien.lithopedion.recipe.ModRecipes;
import net.kalyptien.lithopedion.screen.SculptureTableScreen;
import net.kalyptien.lithopedion.block.ModBlocks;
import net.kalyptien.lithopedion.block.entity.ModBlockEntities;
import net.kalyptien.lithopedion.entity.ModEntities;
import net.kalyptien.lithopedion.entity.client.UndeadRenderer;
import net.kalyptien.lithopedion.item.ModItems;
import net.kalyptien.lithopedion.screen.ModMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(LithopedionMod.MODID)
public class LithopedionMod
{
    public static final String MODID = "lithopedion";
    private static final Logger LOGGER = LogUtils.getLogger();

    public LithopedionMod() {

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        ModCreativeModTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModEntities.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        ModRecipes.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntities.NAGASKELETON.get(), UndeadRenderer::new);
            EntityRenderers.register(ModEntities.ONISKELETON.get(), UndeadRenderer::new);
            EntityRenderers.register(ModEntities.MERMAIDSKELETON.get(), UndeadRenderer::new);
            EntityRenderers.register(ModEntities.GOBLINSKELETON.get(), UndeadRenderer::new);
            EntityRenderers.register(ModEntities.TENGUSKELETON.get(), UndeadRenderer::new);

            MenuScreens.register(ModMenuTypes.SCULPTURE_TABLE_MENU.get(), SculptureTableScreen::new);
        }
    }
}
