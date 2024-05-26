package net.kalyptien.lithopedion.event;

import net.kalyptien.lithopedion.LithopedionMod;
import net.kalyptien.lithopedion.entity.client.ModModelLayers;
import net.kalyptien.lithopedion.entity.client.NagaSkeletonModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LithopedionMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ModModelLayers.NAGASKELETON_LAYER, NagaSkeletonModel::createBodyLayer);
    }

}
