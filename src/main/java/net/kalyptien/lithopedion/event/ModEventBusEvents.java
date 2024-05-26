package net.kalyptien.lithopedion.event;

import net.kalyptien.lithopedion.LithopedionMod;
import net.kalyptien.lithopedion.entity.ModEntities;
import net.kalyptien.lithopedion.entity.custom.NagaSkeletonEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LithopedionMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.NAGASKELETON.get(), NagaSkeletonEntity.createAttribute().build());
    }

}
