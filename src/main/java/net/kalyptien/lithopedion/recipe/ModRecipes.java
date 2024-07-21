package net.kalyptien.lithopedion.recipe;

import net.kalyptien.lithopedion.LithopedionMod;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, LithopedionMod.MODID);

    public static final RegistryObject<RecipeSerializer<SculptureTableRecipe>> GEM_POLISHING_SERIALIZER =
            SERIALIZERS.register("sculpture_table", () -> SculptureTableRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
